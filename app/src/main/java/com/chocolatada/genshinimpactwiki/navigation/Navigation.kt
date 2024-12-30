package com.chocolatada.genshinimpactwiki.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.view.detail.CharacterDetailScreen
import com.chocolatada.genshinimpactwiki.view.main.MainScreen
import com.chocolatada.genshinimpactwiki.view.search.SearchArtifactScreen
import com.chocolatada.genshinimpactwiki.view.search.SearchCharacterScreen
import com.chocolatada.genshinimpactwiki.viewmodel.MainViewModel
import com.chocolatada.genshinimpactwiki.viewmodel.SearchArtifactScreenViewModel
import com.chocolatada.genshinimpactwiki.viewmodel.SearchCharacterScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Main
    ) {
        composable<Main> {
            val mainViewModel: MainViewModel = hiltViewModel()
            val context = LocalContext.current
            MainScreen(
                mainViewModel = mainViewModel,
                onExplore = { navigateToMain(navController) },
                onSaved = { /* todo: navigate to SavedScreen */ },
                onSearch = { key ->
                    when(key) {
                        EntryKeys.CHARACTERS -> navController.navigate(SearchCharacter)
                        EntryKeys.ARTIFACTS -> navController.navigate(SearchArtifacts)
                        else -> Toast.makeText(context, "Coming soon ! ! !", Toast.LENGTH_LONG).show()
                    }
                }
            )
        }
        composable<SearchCharacter> {
            val searchCharacterScreenViewModel: SearchCharacterScreenViewModel = hiltViewModel()
            SearchCharacterScreen(
                onExplore = { navigateToMain(navController) },
                onSaved = { /* todo: navigate to SavedScreen */ },
                onItemDetail = { id ->
                    navController.navigate(CharacterDetail(id))
                },
                viewModel = searchCharacterScreenViewModel
            )
        }
        composable<CharacterDetail> { backStackEntry ->
            val characterDetail: CharacterDetail = backStackEntry.toRoute()
            CharacterDetailScreen(
                onExplore = { navigateToMain(navController) },
                onSaved = { /* todo: navigate to SavedScreen */ },
                id = characterDetail.id
            )
        }
        composable<SearchArtifacts> {
            val viewModel: SearchArtifactScreenViewModel = hiltViewModel()
            SearchArtifactScreen(
                onExplore = { navigateToMain(navController) },
                onSaved = { /* todo: navigate to SavedScreen */ },
                viewModel = viewModel
            )
        }
    }
}

fun navigateToMain(navController: NavController) {
    navController.navigate(Main) {
        popUpTo(Main) {
            inclusive = true
        }
    }
}