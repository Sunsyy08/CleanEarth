package com.example.cleanearth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ───── 아이디어 데이터 클래스 ─────
public data class Idea(
    val id: String,
    val title: String,
    val desc: String,
    val imageRes: Int
)

@Composable
fun IdeaDetailScreen(
    idea: ReformIdeasScreen = ReformIdeasScreen(
        id = "1",
        title = "Flower Vase",
        desc = "플라스틱 병을 반으로 잘라 뒤집어 꽃을 꽂는 방법을 단계별로 안내합니다.",
        imageRes = R.drawable.flowersbottle
    ),
    onRetakeClick: () -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = onRetakeClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Retake")
                }
                Button(
                    onClick = onHomeClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Home")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // 1) 상단 이미지
            Image(
                painter = painterResource(id = idea.imageRes),
                contentDescription = idea.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2) 제목
            Text(
                text = idea.title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 3) 설명
            Text(
                text = idea.desc,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 4) 튜토리얼 스텝
            Text(
                text = "Step-by-Step Tutorial",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = """
                    1. 준비물: 플라스틱 병, 가위, 페인트 등
                    2. 병을 절단하고 깨끗이 세척하기
                    3. 원하는 모양으로 뒤집거나 꾸미기
                    4. 꽃이나 식물을 꽂아서 완성하기
                """.trimIndent(),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(80.dp)) // 버튼과 겹치지 않도록 여유 공간
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIdeaDetailScreen() {
    Surface {
        IdeaDetailScreen()
    }
}


