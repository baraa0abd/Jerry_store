package com.example.jerry_store.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R

@Composable
fun appBar() {
    // Hardcoded values for UI display
    Box(
        modifier = Modifier
            .size(width = 360.dp, height = 56.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // App Logo Section
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 0.5.dp,
                        color = Color(0x261F1F1E),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // Ensure R.drawable.img exists
                    contentDescription = "App logo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Greeting Text Section
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "Hi, Jerry 👋",
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        letterSpacing = 0.sp,
                        color = Color(0xFF1F1F1E)
                    )
                )
                Text(
                    text = "Which Tom do you want to buy?",
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.sp,
                        color = Color(0xFFA5A6A4)
                    )
                )
            }
            Box(
                modifier = Modifier
                    .offset(x = (55).dp, y = (-16).dp)
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF03578A)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3", // Display hardcoded number
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0x261F1F1E),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_1), // Ensure R.drawable.img_1 exists
                    contentDescription = "notification",
                    modifier = Modifier
                        .size(width = 19.5.dp, height = 21.5.dp)
                )

                // Notification Badge - Always displayed
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun AppBarPreview() {
    appBar()
}