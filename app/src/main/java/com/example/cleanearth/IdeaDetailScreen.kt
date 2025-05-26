// ui/IdeaDetailScreen.kt
package com.example.cleanearth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanearth.R
import com.example.cleanearth.data.ReformIdea

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdeaDetailScreen(
    idea: ReformIdea,
    onBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(idea.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            /* 썸네일 이미지 */
            Image(
                painterResource(idea.imageRes),
                contentDescription = idea.name,
                Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            /* 제목 + 부제목 */
            Text(
                idea.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(idea.subtitle, style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(24.dp))

            /* 단계별 튜토리얼 */
            Text(
                "Step-by-Step Tutorial",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(12.dp))

            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    idea.steps.forEachIndexed { i, step ->
                        Text("${i + 1}. $step", style = MaterialTheme.typography.bodyLarge)
                        if (i != idea.steps.lastIndex) Spacer(Modifier.height(6.dp))
                    }
                }
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIdeaDetailScreen() {
    // 간단한 더미 데이터로 미리보기
    val sample = ReformIdea(
        id = "PL01",
        name = "자동 급수 화분",
        subtitle = "뒤집은 병 속 물 공급",
        steps = listOf(
            "물병 뚜껑에 2 mm 구멍 3개 뚫기",
            "물 채운 뒤 거꾸로 화분 흙에 꽂기",
            "3–5일 간격으로 물 보충"
        ),
        imageRes = R.drawable.papercup   // 프로젝트에 있는 임시 이미지
    )
    MaterialTheme { IdeaDetailScreen(sample) }
}
