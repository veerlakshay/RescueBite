package com.lakshay.rescuebite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import com.lakshay.rescuebite.ui.theme.RescueBiteTheme
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.lakshay.rescuebite.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RescueBiteTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}
