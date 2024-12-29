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
import com.chocolatada.genshinimpactwiki.viewmodel.SearchScreenViewModel

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
                onSaved = { /* todo: navigate to SavedScreen */ },
                onSearch = { key -> navController.navigate(Search(key)) }
            )
        }
        composable<Search> { backStackEntry ->
            val search: Search = backStackEntry.toRoute()
            val searchScreenViewModel: SearchScreenViewModel = hiltViewModel()
            SearchScreen(
                onExplore = {
                    navController.navigate(Main) {
                        popUpTo(Main) {
                            inclusive = true
                        }
                    }
                },
                onSaved = { /* todo: navigate to SavedScreen */ },
                searchScreenViewModel = searchScreenViewModel,
                key = search.key
            )
        }
    }
}