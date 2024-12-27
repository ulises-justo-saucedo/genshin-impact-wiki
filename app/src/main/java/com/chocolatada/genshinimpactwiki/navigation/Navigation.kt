package com.chocolatada.genshinimpactwiki.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chocolatada.genshinimpactwiki.view.main.MainScreen
import com.chocolatada.genshinimpactwiki.viewmodel.MainViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Main
    ) {
        composable<Main> {
            val mainViewModel: MainViewModel = hiltViewModel()
            MainScreen(mainViewModel = mainViewModel)
        }
    }
}