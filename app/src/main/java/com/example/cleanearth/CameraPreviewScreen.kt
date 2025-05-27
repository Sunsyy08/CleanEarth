package com.example.cleanearth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CameraPreviewScreen(
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    onNavigateToCamera: () -> Unit = {}
) {
    val currentRoute = "camera"
    val darkGreen = Color(0xFF4CAF50)

    Scaffold(
        bottomBar = {
            BottomNav(
                currentRoute = currentRoute,
                onTabSelect = { route ->
                    when (route) {
                        "home" -> onNavigateToSignUp()
                        "camera" -> onNavigateToCamera() // 현재 화면이지만 유지
                        "profile" -> onNavigateToLogin()
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .weight(0.55f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("카메라 미리보기", fontSize = 13.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(darkGreen.copy(alpha = 0.6f), shape = MaterialTheme.shapes.large),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}


@Composable
fun BottomNavigationBar(currentRoute: String, onTabSelect: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "홈") },
            selected = currentRoute == "home",
            onClick = { onTabSelect("home") },
            label = { Text("홈") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.PhotoCamera, contentDescription = "카메라") },
            selected = currentRoute == "camera",
            onClick = { onTabSelect("camera") },
            label = { Text("카메라") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "프로필") },
            selected = currentRoute == "profile",
            onClick = { onTabSelect("profile") },
            label = { Text("프로필") }
        )
    }
}
