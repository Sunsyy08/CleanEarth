package com.example.cleanearth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CameraPreviewScreen(
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    onNavigateToCamera: () -> Unit = {}
) {
    val currentRoute = "camera"
    val darkGreen = Color(0xFF4CAF50)

    var showLoading by remember { mutableStateOf(false) }
    var showBanner  by remember { mutableStateOf(false) }        // 🔸 배너 표시 여부

    val scope = rememberCoroutineScope()                         // 🔸

    /* 🔸 로딩 → 배너 전환 */
    LaunchedEffect(showLoading) {
        if (showLoading) {
            delay(2000)          // AI 분석 대기(2초 예시)
            showLoading = false  // 로딩창 닫기
            showBanner  = true   // 배너 내려오기
        }
    }
    /* 🔸 배너 자동 사라짐 */
    LaunchedEffect(showBanner) {
        if (showBanner) {
            delay(2500)          // 2.5초 노출 후
            showBanner = false
        }
    }

    /* ───── UI 루트: Box로 감싸 배너 오버레이 ───── */
    Box {
        /* --- 기존 Scaffold 그대로 --- */
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    currentRoute = currentRoute,
                    onTabSelect = { route ->
                        when (route) {
                            "home"    -> onNavigateToSignUp()
                            "camera"  -> onNavigateToCamera()
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
                        .clickable {                      // 기존 클릭 + 로딩
                            scope.launch { showLoading = true }
                        },
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

        /* 🔸 로딩 다이얼로그 */
        if (showLoading) LoadingDialog()

        /* 🔸 상단 배너 */
        DetectionBanner(
            message = "재활용 불가! 일반쓰레기로 배출하세요",
            visible = showBanner
        )
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

/* ───── 둥근-긴 박스 형태의 배너 ───── */
@Composable
fun DetectionBanner(
    message: String,
    visible: Boolean,
    bgColor: Color = Color(0xFFB00020),
    textColor: Color = Color.White,
    topMargin: Dp = 32.dp            // 🔸 원하는 만큼 띄우기
) {
    AnimatedVisibility(
        visible = visible,
        modifier = Modifier               // ← 상단 여백 추가
            .fillMaxWidth()
            .padding(top = topMargin),
        enter = slideInVertically { -it },
        exit  = slideOutVertically { -it }
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .shadow(4.dp, RoundedCornerShape(50))
                .clip(RoundedCornerShape(50))
                .background(bgColor.copy(alpha = 0.7f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
            )
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
