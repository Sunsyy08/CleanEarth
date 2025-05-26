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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// ───── 아이디어 데이터 클래스 ─────
public data class ReformIdeasScreen(
    val id: String,
    val title: String,
    val desc: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReformIdeasScreen(
    onIdeaClick: (ReformIdeasScreen) -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    // 샘플 아이디어 목록
    val ideas = listOf(
        ReformIdeasScreen(
            "1",
            "Flower Vase",
            "플라스틱 병을 반으로 자른 후, 윗부분을 뒤집어 꽃을 꽂을 수 있는 모양으로 변형하고 꾸며주세요.",
            R.drawable.flowersbottle
        ),
        ReformIdeasScreen(
            "2",
            "Self-Watering Pot",
            "병 아래 물을 담고 윗부분에 흙과 식물을 넣어 자동 급수 화분을 만드세요.",
            R.drawable.papercup
        ),
        ReformIdeasScreen(
            "3",
            "Bird Feeder",
            "병을 가로로 잘라 옆에 구멍을 뚫고 씨앗을 넣어 새 모이통으로 활용하세요.",
            R.drawable.flowersbottle
        ),
        ReformIdeasScreen("4", "Pencil Holder", "병을 적당한 높이로 잘라 연필꽂이로 사용하고 외부를 꾸며주세요.", R.drawable.flowersbottle)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Reform Ideas") },
                actions = {
                    IconButton(onClick = onHomeClick) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                }
            )
        }
    ) { innerPadding ->
        // 상단 UI는 그대로 두고, 콘텐츠를 더 아래로 위치하도록 top padding을 늘렸습니다.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
        ) {
            Text(
                "추천 리폼 아이디어",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(ideas) { idea ->
                    Image(
                        painter = painterResource(id = idea.imageRes),
                        contentDescription = idea.title,
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(ideas) { idea ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onIdeaClick(idea) } // 👉 클릭 시 상세화면 이동
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = idea.imageRes),
                            contentDescription = idea.title,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(MaterialTheme.shapes.medium),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                idea.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                idea.desc,
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
