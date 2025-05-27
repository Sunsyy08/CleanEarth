package com.example.cleanearth

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cleanearth.MainScreen
import com.example.cleanearth.ui.UserProfileScreen
import com.example.cleanearth.ReformIdeasScreen
import com.example.cleanearth.ReformNavHost
import com.example.cleanearth.ui.theme.CleanEarthTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanEarthTheme {
//                StartScreen()
            //SignUpScreen()
                //ProfileScreen()
//                LoginScreen()
                //MainScreen()
                //UserProfileScreen()
                //ReformIdeasScreen()
                //IdeaDetailScreen()
                ReformNavHost()
                //CameraPreviewScreen()
            }
        }
    }
}

