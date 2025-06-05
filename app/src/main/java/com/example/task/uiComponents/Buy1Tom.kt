package com.example.task.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.ui.theme.TaskTheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontFamily


data class TomCharacter(
    val name: String,
    val description: String,
    val cheeseCost: Int,
    val imageResId: Int
)

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    val tomCharacters = listOf(
        TomCharacter("Sport Tom", "He runs 1 meter... trips over his boot.", 3, R.drawable.sport),
        TomCharacter("Tom the lover", "He loves one-sidedly... and is beaten by the other side.", 5, R.drawable.lover),
        TomCharacter("Tom the bomb", "He blows himself up before Jerry can catch him.", 10, R.drawable.tom),
        TomCharacter("Spy Tom", "Disguises itself as a table.", 12, R.drawable.spy),
        TomCharacter("Frozen Tom", "He was chasing Jerry, he froze from the first look", 10, R.drawable.frozen),
        TomCharacter("Sleeping Tom", "He doesn't chase anyone, he just snores in stereo.", 10, R.drawable.sleeping)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF2F3F5)), // This light gray background corresponds to the overall screen background
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
    ) {
        item {
            // SearchBarComponent's internal padding (16dp horizontal) should now be the outer padding
            SearchBarComponent() // This component has internal padding (16dp horizontal)
        }

        item {
            // BannerCard should *not* have its own horizontal padding anymore
            BannerCard(
                modifier = Modifier.fillMaxWidth() // Now it will extend to the edges of the LazyColumn's content area
            )
        }

        item {
            // TomSectionHeader should *not* have its own horizontal padding anymore
            TomSectionHeader(
                title = "Cheap tom section",
                modifier = Modifier.fillMaxWidth() // Now it will extend to the edges of the LazyColumn's content area
            )
        }

        items(tomCharacters.chunked(2)) { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(), // Row takes up full width within LazyColumn's padding
                horizontalArrangement = Arrangement.spacedBy(20.dp), // Space between columns
                verticalAlignment = Alignment.Top
            ) {
                pair.forEach { character ->
                    TomCard(
                        character = character,
                        modifier = Modifier.weight(1f) // Each card takes equal weight
                    )
                }
                if (pair.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
@Composable
fun BannerCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(92.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF03578A),
                        Color(0xFF2080BC)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF03446A), Color(0xFF0685D0)),
                        start = Offset(50f, 50f),
                        end = Offset(100f, 100f)
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            // Text content
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(225.dp)
                    .padding(start = 24.dp, top = 12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Buy 1 Tom and get 2 for free",
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Adopt Tom! (Free Fail-Free Guarantee)",
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                )
            }

            // Image overlay
            Box(
                modifier = Modifier
                    .offset(y=25.dp)
                    .width(200.4.dp)
                    .height(250.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = (-16).dp) // Use offset instead of negative padding
            ) {
                Image(
                    painter = painterResource(R.drawable.money),
                    contentDescription = "Promotional Banner",
                )
            }
        }
    }
}

@Composable
fun TomSectionHeader(title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(), // Fills the width of the LazyColumn's content area
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "View all",
            color = Color(0xFF03578A),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
@Composable
fun TomCard(character: TomCharacter, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .size(160.dp, 219.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(width = 93.33.dp, height = 100.dp)
                    .offset(y = (-16).dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.sport),
                    contentDescription = "Tom Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.height(27.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "tom",
                        style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp, textAlign = TextAlign.Center, color = Color(0xFF1F1F1E)),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Box(
                    modifier = Modifier.height(54.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "tom",
                        style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, textAlign = TextAlign.Center, color = Color(0xFF969799)),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround, // Distribute cheese and cart
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Example for cheese and amount
                    Image(painterResource(R.drawable.cheese), contentDescription = "Cheese", modifier = Modifier.size(16.dp))
                }
                // Example for cart icon
                Image(painterResource(R.drawable.shopping), contentDescription = "Add to cart", modifier = Modifier.size(24.dp))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewHomeScreenContent() {
    TaskTheme {
        HomeScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBannerCard() {
    TaskTheme {
        BannerCard(modifier = Modifier.padding(horizontal = 16.dp))
    }
}