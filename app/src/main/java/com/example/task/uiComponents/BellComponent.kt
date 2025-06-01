package com.example.task

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme

@Composable
fun MessageRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.appstore),
            contentDescription = "User profile picture",
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(9.60.dp))
        )

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Hi, Jerry",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "👋",
                    modifier = Modifier.padding(start = 4.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(
                text = "Which Tom do you want to buy?",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun NotificationBell(count: Int) {
    Box(
        modifier = Modifier
            .size(56.dp) // Overall touch target (standard Material Design)
            .padding(end = 8.dp), // Right padding from TopAppBar edge
        contentAlignment = Alignment.Center // Center the content within this 56dp box
    ) {
        // This Box represents the 40x40 background with stroke and rounded corners
        Box(
            modifier = Modifier
                .size(40.dp) // W:40, H:40
                .clip(RoundedCornerShape(12.dp)) // Corner radius: 12
                .background(Color.White) // Fill: FFFFFF (white)
                .border( // Apply the stroke
                    width = 1.dp, // Weight: 1
                    color = Color(0x261F1F1E), // Color: 1F1F1E with 15% opacity
                    shape = RoundedCornerShape(12.dp) // Same rounded shape for the border
                )
                .padding(2.dp), // Padding: 2 (applied uniformly inside the box before content)
            contentAlignment = Alignment.Center // Center the icon within this 40dp box
        ) {
            IconButton(
                onClick = { /* Handle notification bell click */ },
                modifier = Modifier.size(24.dp) // Standard icon size
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color(0xFF1F1F1E) // Bell icon color: 1F1F1E (almost black)
                )
            }
        }

        // Notification badge (the small circle with '3')
        if (count > 0) {
            Box(
                modifier = Modifier
                    .size(14.dp) // Dimensions: W:14, H:14
                    .clip(CircleShape) // Corner radius: 100 (for 14x14, this is CircleShape)
                    .background(Color(0xFF03578A)) // Fill: 03578A (dark blue)
                    .offset(x = 35.dp, y = 4.dp) // Adjusted offset based on Figma X,Y for the badge
                    .padding(0.dp), // Padding: 0 (uniform)
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = count.toString(),
                    color = Color.White, // Badge text color: FFFFFF (white)
                    fontSize = 8.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

// Previews for MessageRow and NotificationBell
@Preview(showBackground = true)
@Composable
fun PreviewMessageRowOnly() {
    TaskTheme {
        MessageRow()
    }
}

@Preview(showBackground = true, widthDp = 80, heightDp = 80)
@Composable
fun PreviewNotificationBell() {
    TaskTheme {
        NotificationBell(count = 3)
    }
}