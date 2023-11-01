package com.flexath.fontorama.ui.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import com.flexath.fontorama.ui.theme.NunitoSans

object NavigationDrawer {
    val navigationItems = listOf(
        NavigationItem(
            title = "How it works",
            selectedIcon = Icons.Filled.Call,
            unSelectedIcon = Icons.Outlined.Call,
            hasNew = false,
            typeface = NunitoSans
        ),
        NavigationItem(
            title = "Rate App",
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search,
            hasNew = false,
            typeface = NunitoSans
        ),
        NavigationItem(
            title = "Privacy Policy",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings,
            hasNew = true,
            typeface = NunitoSans
        ),
    )
}