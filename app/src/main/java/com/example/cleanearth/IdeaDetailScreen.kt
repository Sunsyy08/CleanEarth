// ui/IdeaDetailScreen.kt
package com.example.cleanearth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.example.cleanearth.data.ReformIdea

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdeaDetailScreen(
    idea: ReformIdea,
    onBack: () -> Unit = {},
    onRetake: () -> Unit = {},   // 카메라 다시 찍기
    onHome: () -> Unit = {}      // 홈으로 이동
) {
    val mainColor = Color(0xFF4CAF50)
    val white = Color(0xffffffff)


    Scaffold(
        /* ── 상단 AppBar ── */
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(idea.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = white,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.White
                )
            )
        },

        /* ── 하단 버튼 바 ── */
        bottomBar = {
            BottomAppBar(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    /* RETAKE */
                    FilledTonalButton(
                        onClick = onRetake,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = mainColor,
                            contentColor = Color.White
                        )
                    ) {
                        Text("RETAKE")
                    }

                    /* HOME */
                    OutlinedButton(
                        onClick = onHome,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = mainColor),
                        border = BorderStroke(1.dp, mainColor),
                    ) {
                        Text("HOME")
                    }
                }
            }
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            /* ── 썸네일 ── */
            Image(
                painterResource(idea.imageRes),
                contentDescription = idea.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            /* ── 제목 & 부제목 ── */
            Text(
                idea.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(idea.subtitle, style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(24.dp))

            /* ── 단계별 튜토리얼 ── */
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

            Spacer(Modifier.height(80.dp)) /* 하단 바와 내용 간 여유 */
        }
    }
}
