package com.lakshay.rescuebite.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lakshay.rescuebite.screen.DonateFoodScreen
import com.lakshay.rescuebite.screen.RequestFoodScreen
import com.lakshay.rescuebite.screen.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(
                onDonateClick = { navController.navigate("donateFood") },
                onRequestClick = { navController.navigate("requestFood") }
            )
        }
        composable("donateFood") { DonateFoodScreen(navController) }
        composable("requestFood") { RequestFoodScreen(navController) }
    }
}
