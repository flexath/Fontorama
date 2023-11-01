package com.flexath.fontorama.ui.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.flexath.fontorama.ui.screens.Screen
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

//NavigationBarItem(
//selected = bottomNavigationItemIndex == index,
//alwaysShowLabel = false,
//label = {
//    Text(
//        text = navigationItem.title,
//        fontFamily = navigationItem.typeface,
//        fontWeight = FontWeight.Bold
//    )
//},
//onClick = {
//    bottomNavigationItemIndex = index
//
//    when (bottomNavigationItemIndex) {
//        0 -> navHostController.navigate(Screen.ScreenText.route)
//        1 -> navHostController.navigate(Screen.ScreenSearch.route)
//        else -> navHostController.navigate(Screen.ScreenSetting.route)
//    }
//}, icon = {
//    BadgedBox(
//        badge = {
//            if (navigationItem.hasNew) {
//                Badge()
//            }
//        }
//    ) {
//        Icon(
//            imageVector = if (index == bottomNavigationItemIndex) {
//                navigationItem.selectedIcon
//            } else {
//                navigationItem.unSelectedIcon
//            },
//            contentDescription = "${navigationItem.title}'s clicked"
//        )
//    }
//}
//)