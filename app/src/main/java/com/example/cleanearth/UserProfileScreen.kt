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
import com.example.cleanearth.BottomNav

@Composable
fun UserProfileScreen(
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    onNavigateToCamera: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    val currentRoute = "profile"

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(
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
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 64.dp, bottom = 24.dp)
            )

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(vertical = 16.dp)) {
                    ProfileItem(label = "Name",  value = "홍길동")
                    Divider(thickness = 1.dp, color = Color.LightGray)
                    ProfileItem(label = "Email", value = "honggildong@example.com")
                    Divider(thickness = 1.dp, color = Color.LightGray)
                    ProfileItem(label = "Date of Birth", value = "1990년 1월 1일")
                    Divider(thickness = 1.dp, color = Color.LightGray)
                    ProfileItem(label = "Gender", value = "Male")
                    Divider(thickness = 1.dp, color = Color.LightGray)

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
