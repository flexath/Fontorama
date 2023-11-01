package com.flexath.fontorama.ui.menu

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily

data class NavigationItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unSelectedIcon: ImageVector,
    var hasNew: Boolean,
    var typeface: FontFamily
)