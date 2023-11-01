package com.flexath.fontorama.ui.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import com.flexath.fontorama.ui.theme.NunitoSans

object BottomNavigationBar {
    val navigationItems = listOf(
        NavigationItem(
            title = "Text",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            hasNew = false,
            typeface = NunitoSans
        ),
        NavigationItem(
            title = "Search",
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search,
            hasNew = false,
            typeface = NunitoSans
        ),
        NavigationItem(
            title = "Setting",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings,
            hasNew = true,
            typeface = NunitoSans
        ),
    )
}