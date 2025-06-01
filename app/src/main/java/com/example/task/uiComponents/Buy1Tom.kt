package com.example.task.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme

// Data class to represent a Tom character for the cards
data class TomCharacter(
    val name: String,
    val description: String,
    val cheeseCost: Int,
    val imageResId: Int?
)

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF2F3F5)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        item {
            SearchBarComponent()
        }

        item {
            BannerCard(
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            TomSectionHeader(
                title = "Cheap tom section",
                modifier = Modifier.fillMaxWidth() // Fill width within contentPadding
            )
        }

        val tomCharacters = listOf(
            TomCharacter("Sport Tom", "He runs 1 meter... trips over his boot.", 3, null),
            TomCharacter("Tom the lover", "He loves one-sidedly... and is beaten by the other side.", 5, null),
            TomCharacter("Tom the bomb", "He blows himself up before Jerry can catch him.", 10, null),
            TomCharacter("Spy Tom", "Disguises itself as a table.", 12, null),
            TomCharacter("Frozen Tom", "He was chasing Jerry, he froze from the first look", 10, null),
            TomCharacter("Sleeping Tom", "He doesn't chase anyone, he just snores in stereo.", 10, null),
            // Add more characters to ensure scrolling
            TomCharacter("Chef Tom", "Always cooking up new schemes to catch Jerry.", 15, null),
            TomCharacter("Musician Tom", "Plays the piano, but usually ends up chasing Jerry.", 8, null),
            TomCharacter("Athlete Tom", "Trains hard, but still can't outsmart a mouse.", 7, null),
            TomCharacter("Scientist Tom", "Experiments gone wrong are his specialty.", 11, null)
        )

        item {
            // IMPORTANT: Using Modifier.height(IntrinsicSize.Max) to allow LazyVerticalGrid
            // to measure its full height based on its content when nested inside LazyColumn.
            // This transfers scrolling responsibility to the parent LazyColumn.
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp), // <--- CHANGE THIS FOR PREVIEW. Use a value large enough to show all items.
                // .height(IntrinsicSize.Max), // Keep this line commented out for preview
                userScrollEnabled = false,
                contentPadding = PaddingValues(0.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(tomCharacters) { character ->
                    TomCard(character = character)
                }
            }
        }
    }
}

// ... (BannerCard, TomSectionHeader, TomCard remain the same as previous updates)
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
        // Placeholder for the background image
        // When you have the image:
        /*
        Image(
            painter = painterResource(id = R.drawable.tom_jerry_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterEnd,
            modifier = Modifier.fillMaxSize()
        )
        */
        // Using a colored Box as a placeholder for the image
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.3f)) // A semi-transparent gray placeholder
        )


        // Overlay with text (transparent dark overlay if needed)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)) // Subtle dark overlay for text readability
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp)
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Buy 1 Tom and get 2 for free",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Adopt Tom! (Free Fail-Free Guarantee)",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TomSectionHeader(title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
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
            .fillMaxWidth()
            .aspectRatio(0.7f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Tom's Image Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray) // Light gray placeholder
            ) {
                // When you have the image:
                /*
                character.imageResId?.let { resId ->
                    Image(
                        painter = painterResource(id = resId),
                        contentDescription = character.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                */
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = character.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = character.description,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Placeholder for cheese icon
                    Icon(
                        painter = ColorPainter(Color(0xFF03578A)), // Blue placeholder for cheese icon
                        // When you have the image: painter = painterResource(id = R.drawable.cheese_icon),
                        contentDescription = "Cheese cost",
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF03578A) // Blue tint for cheese icon
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${character.cheeseCost} cheeses",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                IconButton(
                    onClick = { /* Add to cart */ },
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF03578A))
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Add to cart",
                        tint = Color.White
                    )
                }
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

@Preview(showBackground = true)
@Composable
fun PreviewTomCard() {
    TaskTheme {
        TomCard(
            character = TomCharacter(
                "Sport Tom",
                "He runs 1 meter... trips over his boot.",
                3,
                null
            )
        )
    }
}