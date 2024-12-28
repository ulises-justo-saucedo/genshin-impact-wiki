package com.chocolatada.genshinimpactwiki.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.chocolatada.genshinimpactwiki.view.main.MainScreen
import com.chocolatada.genshinimpactwiki.view.search.SearchScreen
import com.chocolatada.genshinimpactwiki.viewmodel.MainViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Main
    ) {
        composable<Main> {
            val mainViewModel: MainViewModel = hiltViewModel()
            MainScreen(
                mainViewModel = mainViewModel,
                onExplore = {
                navController.navigate(Main) {
                    popUpTo(Main) {
                        inclusive = true
                    }
                }
            },
            onSaved = { /* todo: navigate to SavedScreen */ })
        }
        composable<Search> { backStackEntry ->
            val search: Search = backStackEntry.toRoute()
            SearchScreen(inputText = search.inputText, onExplore = {
                navController.navigate(Main) {
                    popUpTo(Main) {
                        inclusive = true
                    }
                }
            }, onSaved = { /* todo: navigate to SavedScreen */ })
        }
    }
}