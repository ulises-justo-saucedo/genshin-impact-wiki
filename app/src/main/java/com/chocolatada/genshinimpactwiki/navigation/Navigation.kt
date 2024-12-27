package com.chocolatada.genshinimpactwiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chocolatada.genshinimpactwiki.view.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Main
    ) {
        composable<Main> {
            MainScreen()
        }
    }
}