// ReformNavHost.kt
package com.example.cleanearth

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

@Composable
fun ReformNavHost() {
    val navController = rememberNavController()

    val ideas = listOf(
        ReformIdeasScreen("1", "Flower Vase", "플라스틱 병을 꽃병으로 리폼", R.drawable.flowersbottle),
        ReformIdeasScreen("2", "Self-Watering Pot", "병 아래 물을 담고 자동 급수 화분 만들기", R.drawable.papercup),
        ReformIdeasScreen("3", "Bird Feeder", "병을 잘라 씨앗 담기", R.drawable.flowersbottle),
        ReformIdeasScreen("4", "Pencil Holder", "병을 잘라 연필꽂이 만들기", R.drawable.flowersbottle)
    )

    NavHost(navController = navController, startDestination = "ideas") {
        composable("ideas") {
            ReformIdeasScreen(
                onIdeaClick = { idea ->
                    navController.navigate("detail/${idea.id}")
                }
            )
        }

        composable(
            "detail/{ideaId}",
            arguments = listOf(navArgument("ideaId") { type = NavType.StringType })
        ) { backStackEntry ->
            val ideaId = backStackEntry.arguments?.getString("ideaId")
            val idea = ideas.find { it.id == ideaId }
            idea?.let {
                IdeaDetailScreen(idea = it)
            }
        }
    }
}
