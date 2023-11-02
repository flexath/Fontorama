package com.flexath.fontorama.ui.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.flexath.fontorama.ui.screens.Screen
import com.flexath.fontorama.ui.theme.DMSans
import com.flexath.fontorama.ui.theme.NunitoSans

object BottomNavigationBar {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            hasNew = false,
            typeface = DMSans
        ),
        NavigationItem(
            title = "Search",
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search,
            hasNew = false,
            typeface = DMSans
        ),
        NavigationItem(
            title = "Favourite",
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Outlined.FavoriteBorder,
            hasNew = false,
            typeface = DMSans
        ),
        NavigationItem(
            title = "Setting",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings,
            hasNew = false,
            typeface = DMSans
        )
    )
}

