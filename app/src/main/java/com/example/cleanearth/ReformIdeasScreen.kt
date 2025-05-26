// ui/ReformIdeasScreen.kt
package com.example.cleanearth

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
// ReformIdea, getRandomIdeas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReformIdeasScreen(
    category: String,                     // 예: "플라스틱"
    onIdeaClick: (ReformIdea) -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    /* 상태: 현재 추천 리스트(최초 4개) */
    var ideas by remember(category) {
        mutableStateOf(getRandomIdeas(category, 4))
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("$category 리폼 아이디어") },
                actions = {
                    IconButton(onClick = onHomeClick) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
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

            /* ----- 카테고리 대표 썸네일 Row ----- */
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(ideas) { idea ->
                    Image(
                        painter = painterResource(id = idea.imageRes),
                        contentDescription = idea.name,
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            /* 다시 추천 버튼 */
            OutlinedButton(
                onClick = { ideas = getRandomIdeas(category, 4) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("다시 추천")
            }

            Spacer(modifier = Modifier.height(16.dp))

            /* ----- 카드 리스트 ----- */
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(ideas) { idea ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onIdeaClick(idea) }
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = idea.imageRes),
                            contentDescription = idea.name,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(MaterialTheme.shapes.medium),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
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
