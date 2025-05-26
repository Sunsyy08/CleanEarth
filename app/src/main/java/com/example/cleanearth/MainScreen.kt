package com.example.cleanearth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanearth.R

@Composable
fun MainScreen(
    onCheckRecycle: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Scaffold(
        bottomBar = {
            BottomNav(
                selectedIndex = 0,
                onNavigateToSignUp = onNavigateToSignUp,
                onNavigateToLogin = onNavigateToLogin
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "CleanEarth",
                    color = Color(0xFF121717),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Hero Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp)
            ) {
                // Background image
                Image(
                    painter = painterResource(id = R.drawable.mainimage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
                // Gradient overlay for readability
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.1f),
                                    Color.Black.copy(alpha = 0.4f)
                                )
                            )
                        )
                )
                // Text content
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .matchParentSize()
                        .padding(bottom = 200.dp)
                ) {
                    Text(
                        text = "재활용? 이젠 고민하지 마세요!",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 45.sp,
                        modifier = Modifier.padding(horizontal = 22.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "사진 한 장으로 재활용 가능 여부를 알 수 있어요.",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 21.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Check Recycle Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onCheckRecycle,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF17CFA1)),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = "카메라",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = "재활용 여부, 지금 확인!",
                        color = Color(0xFF121717),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Today's Reform Recommendation Title
            Text(
                text = "오늘의 리폼 추천",
                color = Color(0xFF121717),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                val recommendations = listOf(
                    Recommendation(R.drawable.can, "플라스틱의 새로운 쓰임!", "물병이 화분이 된다면? 지금 아이디어 보기"),
                    Recommendation(R.drawable.glassbottle, "유리병, 버리지 마세요", "인테리어 소품으로 재탄생하는 법!"),
                    Recommendation(R.drawable.paperbag, "종이가방의 반전 매력", "포장지부터 수납함까지, 다양하게 활용해보세요")
                )
                recommendations.forEach { item ->
                    RecommendationItem(item)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Guide Section Title
            Text(
                text = "Guide",
                color = Color(0xFF121717),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            val guideItems = listOf(
                GuideItem(R.drawable.newspaper, "최신 재활용 뉴스"),
                GuideItem(R.drawable.recycleitem, "가장 많이 분석된 품목"),
                GuideItem(R.drawable.reformidea, "리폼 아이디어 모음")
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(guideItems) { item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.width(280.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(8.dp))
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = item.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.matchParentSize()
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = item.title,
                            color = Color(0xFF121717),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

private data class Recommendation(
    val imageRes: Int,
    val title: String,
    val subtitle: String
)

private data class GuideItem(
    val imageRes: Int,
    val title: String
)

@Composable
private fun RecommendationItem(
    item: Recommendation,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = item.title,
                color = Color(0xFF121717),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = item.subtitle,
                color = Color(0xFF638780),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
private fun BottomNav(
    selectedIndex: Int,
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .height(64.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val navItems = listOf(
            "Home" to Icons.Filled.Home,
            "Camera" to Icons.Filled.CameraAlt,
            "Profile" to Icons.Filled.AccountCircle
        )
        navItems.forEachIndexed { index, (label, icon) ->
            val selected = index == selectedIndex
            Column(
                modifier = Modifier
                    .clickable {
                        when (label) {
                            "Home" -> onNavigateToSignUp()
                            "Camera" -> {}
                            "Profile" -> onNavigateToLogin()
                        }
                    }
                    .padding(horizontal = 12.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = if (selected) Color(0xFF121717) else Color(0xFF638780),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = label,
                    color = if (selected) Color(0xFF121717) else Color(0xFF638780),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}
