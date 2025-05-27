package com.example.cleanearth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.delay

@Composable
fun CameraPreviewScreen(
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    onNavigateToCamera: () -> Unit = {}
) {
    val currentRoute = "camera"
    val darkGreen = Color(0xFF4CAF50)

    var showLoading by remember { mutableStateOf(false) }

    // 로딩이 true일 때 2초 후 자동 해제
    if (showLoading) {
        LoadingDialog()
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onTabSelect = { route ->
                    when (route) {
                        "home" -> onNavigateToSignUp()
                        "camera" -> onNavigateToCamera()
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
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("카메라 미리보기", fontSize = 13.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 버튼 클릭 시 로딩 표시
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(darkGreen.copy(alpha = 0.6f), shape = MaterialTheme.shapes.large)
                    .clickable { showLoading = true },
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
fun LoadingDialog() {
    // 점 개수 (".", "..", "..." 로 순환)
    var dotCount by remember { mutableStateOf(0) }

    // 애니메이션 루프
    LaunchedEffect(Unit) {
        while (true) {
            delay(500) // 0.5초마다 점 개수 변경
            dotCount = (dotCount + 1) % 4
        }
    }

    val dots = ".".repeat(dotCount) // 점 개수에 따라 문자열 생성

    AlertDialog(
        onDismissRequest = {},
        confirmButton = {},
        title = null,
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = Color(0xFF4CAF50),
                    trackColor = Color(0xFFC8E6C9)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("AI 분석중$dots", fontSize = 16.sp)
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    )
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
