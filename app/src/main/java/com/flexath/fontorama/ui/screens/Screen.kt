package com.flexath.fontorama.ui.screens

const val ROUTE_TEXT_SCREEN = "text_screen"
const val ROUTE_SEARCH_SCREEN = "search_screen"
const val ROUTE_SETTING_SCREEN = "setting_screen"

sealed class Screen(val route: String) {
    data object ScreenText : Screen(route = ROUTE_TEXT_SCREEN)
    data object ScreenSearch : Screen(route = ROUTE_SEARCH_SCREEN)
    data object ScreenSetting : Screen(route = ROUTE_SETTING_SCREEN)
}