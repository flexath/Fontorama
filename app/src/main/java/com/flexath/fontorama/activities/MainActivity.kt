package com.flexath.fontorama.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.exyte.animatednavbar.utils.noRippleClickable
import com.flexath.fontorama.R
import com.flexath.fontorama.ui.menu.BottomNavigationBar
import com.flexath.fontorama.ui.nav_graph.NavGraphHost
import com.flexath.fontorama.ui.screens.Screen
import com.flexath.fontorama.ui.theme.Anton
import com.flexath.fontorama.ui.theme.ColorDarkGray
import com.flexath.fontorama.ui.theme.DarkColorScheme
import com.flexath.fontorama.ui.theme.FontoramaTheme
import com.flexath.fontorama.ui.theme.LightColorScheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FontoramaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if (isSystemInDarkTheme()) {
                        DarkColorScheme.background
                    } else {
                        LightColorScheme.background
                    }
                ) {
                    navHostController = rememberNavController()
                    if (isSystemInDarkTheme()) {
                        ChangeStatusBarColor(
                            DarkColorScheme.background,
                            false,
                            DarkColorScheme.background
                        )
                    } else {
                        ChangeStatusBarColor(
                            LightColorScheme.background,
                            true,
                            LightColorScheme.background
                        )
                    }
                    NavigationSetup(navHostController = navHostController)
                }
            }
        }
    }
}

@Composable
fun ChangeStatusBarColor(color: Color, isDark: Boolean, textColor: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = isDark,
            transformColorForLightContent = {
                textColor
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationSetup(navHostController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    val coroutineScope = rememberCoroutineScope()

    val scrollingBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(280.dp)
            ) {

            }
        },
        drawerState = drawerState,
        modifier = Modifier.fillMaxSize()
    ) {

        var title by rememberSaveable {
            mutableStateOf("Home")
        }

        Scaffold(
            topBar = {
                Surface(
                    shadowElevation = 20.dp
                ) {
                    TopAppBar(
                        title = {
                            Text(
                                text = title,
                                fontFamily = Anton,
                                fontSize = 28.sp,
                                color = changeColorWithDisplayMode(
                                    darkColor = Color.White,
                                    lightColor = LightColorScheme.primary
                                )
                            )

                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.menu_burger),
                                    contentDescription = "Menu Drawer Opened",
                                    tint = changeColorWithDisplayMode(
                                        darkColor = DarkColorScheme.primary,
                                        lightColor = LightColorScheme.primary
                                    )
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = "Info Opened",
                                    tint = changeColorWithDisplayMode(
                                        darkColor = DarkColorScheme.primary,
                                        lightColor = LightColorScheme.primary
                                    )
                                )
                            }
                        },
                        scrollBehavior = scrollingBehaviour,
                        modifier = Modifier.fillMaxWidth(),
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = changeColorWithDisplayMode(
                                darkColor = ColorDarkGray,
                                lightColor = LightColorScheme.background
                            )
                        )
                    )
                }

            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .background(
                            color = changeColorWithDisplayMode(
                                darkColor = Color.Transparent,
                                lightColor = Color.Transparent
                            ),
                        ),
                ) {
//                    BottomNavigationBarSetUp(navHostController)

                    var bottomNavigationItemIndex by rememberSaveable {
                        mutableIntStateOf(0)
                    }

                    Surface (
                        shadowElevation = 20.dp,
                    ) {
                        Box (
                            modifier = Modifier
                                .background(
                                    color = changeColorWithDisplayMode(
                                        darkColor = DarkColorScheme.surface,
                                        lightColor = LightColorScheme.background
                                    )
                                )
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Row (
                                modifier = Modifier.background(
                                    color = if (isSystemInDarkTheme()) {
                                        DarkColorScheme.surface
                                    } else {
                                        LightColorScheme.background
                                    }
                                )
                            ) {
                                BottomNavigationBar.navigationItems.forEachIndexed { index, navigationItem ->
                                    Box(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .noRippleClickable {
                                                bottomNavigationItemIndex = index

                                                when (bottomNavigationItemIndex) {
                                                    0 -> {
                                                        navHostController.popBackStack()
                                                        title = "Home"
                                                        navHostController.navigate(Screen.ScreenText.route)
                                                    }

                                                    1 -> {
                                                        navHostController.popBackStack()
                                                        title = "Search"
                                                        navHostController.navigate(Screen.ScreenSearch.route)
                                                    }

                                                    2 -> {
                                                        navHostController.popBackStack()
                                                        title = "Favourite"
                                                        navHostController.navigate(Screen.ScreenFavourite.route)
                                                    }

                                                    else -> {
                                                        navHostController.popBackStack()
                                                        title = "Setting"
                                                        navHostController.navigate(Screen.ScreenSetting.route)
                                                    }
                                                }
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .background(
                                                    color = if (index == bottomNavigationItemIndex) {
                                                        changeColorWithDisplayMode(
                                                            darkColor = Color.DarkGray,
                                                            lightColor = Color.LightGray
                                                        )
                                                    } else {
                                                        Color.Transparent
                                                    },
                                                    shape = CircleShape
                                                )
                                                .padding(
                                                    start = 12.dp,
                                                    end = 12.dp,
                                                    top = 8.dp,
                                                    bottom = 8.dp
                                                ),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            BadgedBox(
                                                badge = {
                                                    if (navigationItem.hasNew) {
//                                Badge()
                                                    }
                                                }
                                            ) {
                                                BadgedBox(
                                                    badge = {}
                                                ) {
                                                    Icon(
                                                        imageVector = if (index == bottomNavigationItemIndex) {
                                                            navigationItem.selectedIcon
                                                        } else {
                                                            navigationItem.unSelectedIcon
                                                        },
                                                        contentDescription = "${navigationItem.title}'s clicked",
                                                        tint = changeColorWithDisplayMode(
                                                            darkColor = DarkColorScheme.primary,
                                                            lightColor = LightColorScheme.primary
                                                        )
                                                    )
                                                }
                                            }

                                            AnimatedVisibility(visible = index == bottomNavigationItemIndex) {
                                                Text(
                                                    text = navigationItem.title,
                                                    fontFamily = navigationItem.typeface,
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 16.sp
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollingBehaviour.nestedScrollConnection)
        ) { values ->
            NavGraphHost(navHostController = navHostController, values = values)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBarSetUp(navHostController: NavHostController) {

}

@Composable
fun LottieLoader(resId: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        reverseOnRepeat = true,
        restartOnPlay = true
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(32.dp)
    )
}

@Composable
fun changeColorWithDisplayMode(darkColor: Color, lightColor: Color): Color {
    return if (isSystemInDarkTheme()) {
        darkColor
    } else {
        lightColor
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    FontoramaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChangeStatusBarColor(Color.Transparent, true, Color.Black)
            NavigationSetup(navHostController = rememberNavController())
        }
    }
}


//BottomNavigationBar.navigationItems.forEachIndexed { index, navigationItem ->
//    NavigationBarItem(
//        selected = bottomNavigationItemIndex == index,
//        alwaysShowLabel = true,
//        label = {
//            Text(
//                text = navigationItem.title,
//                fontFamily = navigationItem.typeface,
//                fontWeight = FontWeight.ExtraBold,
//                fontSize = 16.sp,
//                color = if(index == bottomNavigationItemIndex) LightColorScheme.primary
//                else Color.DarkGray
//            )
//        },
//        onClick = {
//            bottomNavigationItemIndex = index
//
//            when (bottomNavigationItemIndex) {
//                0 -> navHostController.navigate(Screen.ScreenText.route)
//                1 -> navHostController.navigate(Screen.ScreenSearch.route)
//                else -> navHostController.navigate(Screen.ScreenSetting.route)
//            }
//        }, icon = {
//            BadgedBox(
//                badge = {
//                    if (navigationItem.hasNew) {
//                        Badge()
//                    }
//                }
//            ) {
//                Icon(
//                    imageVector = if (index == bottomNavigationItemIndex) {
//                        navigationItem.selectedIcon
//                    } else {
//                        navigationItem.unSelectedIcon
//                    },
//                    contentDescription = "${navigationItem.title}'s clicked"
//                )
//            }
//        },
//        colors = NavigationBarItemDefaults.colors(
//            selectedIconColor = changeColorWithDisplayMode(
//                darkColor = Color.White,
//                lightColor = Color.DarkGray
//            ),
//            unselectedIconColor = Color.Gray,
//            selectedTextColor = changeColorWithDisplayMode(
//                darkColor = Color.White,
//                lightColor = Color.DarkGray
//            ),
//            unselectedTextColor = changeColorWithDisplayMode(
//                darkColor = Color.White,
//                lightColor = Color.DarkGray
//            ),
//            indicatorColor = Color.Gray
//        )
//    )
//}