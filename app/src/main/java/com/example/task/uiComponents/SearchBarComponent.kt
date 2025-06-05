package com.example.task.uiComponents // Assuming your package name is uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme

@Composable
fun SearchBarComponent() {
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp) // H: 48 (overall container height)
            .clip(RoundedCornerShape(12.dp)) // Corner radius: 12 (overall container)
            .background(Color.White) // Fill: FFFFFF (white, 100% overall container)
            .border( // Stroke: A5A6A4 at 8% opacity, Weight: 1, Position: Inside
                width = 1.dp,
                color = Color(0x14A5A6A4), // 0x14 is 8% of 255
                shape = RoundedCornerShape(12.dp) // Same shape as clip
            )
            .padding(12.dp) // Padding: 12 (uniform padding inside the box)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), // This Row fills the available width after outer padding
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Gap: 8 (between search input and filter button)
        ) {
            Box(
                modifier = Modifier.size(272.dp,48.dp)
            ){
                // Search Input Area (Left side)
                Row( // Takes up remaining space horizontally
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between search icon and text
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        tint = Color(0xFF969799), // Text color: 969799 (gray)
                        modifier = Modifier.size(20.dp) // Standard icon size
                    )
                    BasicTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        textStyle = TextStyle(
                            color = Color(0xFF1F1F1E),
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.fillMaxWidth(), // Fills available space in the Row
                        decorationBox = { innerTextField ->
                            if (searchText.isEmpty()) {
                                Text(
                                    text = "Search about tom ...",
                                    color = Color(0xFF969799),
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }

            // Filter Button (Right side) - Adjusted padding and icon size
            IconButton(
                onClick = { /* Handle filter click */ },
                modifier = Modifier
                    .offset(x=20.dp)
                    .size(48.dp) // W: 48, H: 48 (overall button size)
                    .clip(RoundedCornerShape(12.dp)) // Corner radius: 12 (applied to the button)
                    .background(Color(0xFF03578A)) // Fill: 03578A (dark blue, 100%)
            ) {
                Icon(
                    imageVector = Icons.Default.Tune, // Filter icon
                    contentDescription = "Filter",
                    tint = Color.White, // Icon tint: FFFFFF (white)
                    modifier = Modifier.size(36.dp) // Adjusted icon size to 36dp for larger appearance
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBarComponent() {
    TaskTheme {
        SearchBarComponent()
    }
}