package com.flexath.fontorama.ui.nav_graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.flexath.fontorama.ui.screens.FavouriteScreen
import com.flexath.fontorama.ui.screens.HomeScreen
import com.flexath.fontorama.ui.screens.Screen
import com.flexath.fontorama.ui.screens.SearchScreen
import com.flexath.fontorama.ui.screens.SettingScreen

@Composable
fun NavGraphHost(navHostController: NavHostController, values: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ScreenText.route,
        builder = {
            composable(
                route = Screen.ScreenText.route
            ) {
                HomeScreen(navHostController, values)
            }

            composable(
                route = Screen.ScreenSearch.route
            ) {
                SearchScreen(navHostController, values)
            }

            composable(
                route = Screen.ScreenFavourite.route
            ) {
                FavouriteScreen(navHostController, values)
            }

            composable(
                route = Screen.ScreenSetting.route
            ) {
                SettingScreen(navHostController, values)
            }
        }
    )
}