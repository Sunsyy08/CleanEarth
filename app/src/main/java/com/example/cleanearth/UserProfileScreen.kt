// UserProfileScreen.kt
package com.example.cleanearth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserProfileScreen(
    currentRoute: String = "profile",           // 하단 탭 선택 상태
    onTabSelect: (String) -> Unit = {},         // 탭 변경 콜백
    onLogoutClick: () -> Unit = {}              // 로그아웃 콜백
) {
    /* ─── 예시 프로필 데이터 ─── */
    val name = "홍길동"
    val email = "honggildong@example.com"
    val dateOfBirth = "1990년 1월 1일"
    val gender = "Male"

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavBar(currentRoute, onTabSelect) }   // ③ 하단 탭바
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
        ) {
            /* ─── 타이틀 ─── */
            Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 64.dp, bottom = 24.dp)
            )

            /* ─── 프로필 카드 ─── */
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(vertical = 16.dp)) {
                    ProfileItem(label = "Name",  value = name)
                    Divider(thickness = 1.dp, color = Color.LightGray)

                    ProfileItem(label = "Email", value = email)
                    Divider(thickness = 1.dp, color = Color.LightGray)

                    ProfileItem(label = "Date of Birth", value = dateOfBirth)
                    Divider(thickness = 1.dp, color = Color.LightGray)

                    ProfileItem(label = "Gender", value = gender)
                    Divider(thickness = 1.dp, color = Color.LightGray)

                    /* ─── ② 반투명 회색 로그아웃 줄 ─── */
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onLogoutClick() }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Logout,
                            contentDescription = "Log Out",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "Log Out",
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))
        }
    }
}

/* ────────────────────────────────────────── */
/* 하단 탭바: 홈 화면과 동일하게 재사용      */
@Composable
fun BottomNavBar(currentRoute: String, onSelect: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onSelect("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == "camera",
            onClick = { onSelect("camera") },
            icon = { Icon(Icons.Default.CameraAlt, contentDescription = "Scan") },
            label = { Text("Camera") }
        )
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { onSelect("profile") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") }
        )
    }
}

/* ────────────────────────────────────────── */
@Composable
fun ProfileItem(
    label: String,
    value: String,
    trailingArrow: Boolean = false,
    onClick: () -> Unit = {}
) {
    val clickable = if (trailingArrow) Modifier.clickable { onClick() } else Modifier
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(clickable)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (trailingArrow) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
