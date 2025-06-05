// In MainActivity.kt

package com.example.task
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jerry_store.screens.appBar
import com.example.task.uiComponents.HomeScreenContent
import com.example.task.ui.theme.TaskTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                AppContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    appBar() // This will be at the very top of the screen
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { paddingValues -> // This paddingValues accounts for the TopAppBar's height
        // This Column receives the padding from the Scaffold
        Column(modifier = Modifier.padding(paddingValues)) {
            // Call HomeScreenContent here.
            // HomeScreenContent itself will now contain SearchBarComponent, BannerCard, etc.
            HomeScreenContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppContentWithBell() {
    TaskTheme {
        AppContent()
    }
}