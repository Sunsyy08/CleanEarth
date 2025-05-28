// ui/ReformIdeasScreen.kt
package com.example.cleanearth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cleanearth.data.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReformIdeasScreen(
    category: String,
    onIdeaClick: (ReformIdea) -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    /* ─── 팔레트 ─── */
    val mainColor = Color(0xFF4CAF50)
    val white = Color(0xffffffff)
    val black = Color(0xff000000)

    /* 상태: 현재 추천 리스트(최초 4개) */
    var ideas by remember(category) { mutableStateOf(getRandomIdeas(category, 4)) }

    Scaffold(
        topBar = {
            /* 상단바를 메인 컬러로 통일 */
            CenterAlignedTopAppBar(
                title = { Text("$category 리폼 아이디어") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = white ,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = onHomeClick) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            /* ───── 카테고리 대표 썸네일 Row ───── */
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(ideas) { idea ->
                    Image(
                        painter = painterResource(id = idea.imageRes),
                        contentDescription = idea.name,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            /* ───── “다시 추천” 버튼 ───── */
            OutlinedButton(
                onClick = { ideas = getRandomIdeas(category, 4) },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = mainColor),
                border = BorderStroke(1.dp, mainColor),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("다시 추천")
            }

            Spacer(Modifier.height(16.dp))

            /* ───── 카드 리스트 ───── */
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(ideas) { idea ->
                    /* 그림 + 텍스트를 Card 로 감싸 가독성 ↑ */
                    Card(
                        onClick = { onIdeaClick(idea) },
                        shape = MaterialTheme.shapes.medium,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = idea.imageRes),
                                contentDescription = idea.name,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.width(12.dp))
                            Column {
                                Text(
                                    idea.name,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    idea.subtitle,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
