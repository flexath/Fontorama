package com.flexath.fontorama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.flexath.fontorama.ui.menu.BottomNavigationBar
import com.flexath.fontorama.ui.nav_graph.NavGraphHost
import com.flexath.fontorama.ui.screens.Screen
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

    var bottomNavigationItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val coroutineScope = rememberCoroutineScope()

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
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.menu_burger),
                                contentDescription = "Menu Drawer Opened"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    BottomNavigationBar.navigationItems.forEachIndexed { index, navigationItem ->
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color = DarkColorScheme.primary, shape = CircleShape)
                                .padding(8.dp)
                                .clickable {
                                    bottomNavigationItemIndex = index

                                    when (bottomNavigationItemIndex) {
                                        0 -> navHostController.navigate(Screen.ScreenText.route)
                                        1 -> navHostController.navigate(Screen.ScreenSearch.route)
                                        else -> navHostController.navigate(Screen.ScreenSetting.route)
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.padding(2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                BadgedBox(
                                    badge = {
                                        if (navigationItem.hasNew) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == bottomNavigationItemIndex) {
                                            navigationItem.selectedIcon
                                        } else {
                                            navigationItem.unSelectedIcon
                                        },
                                        contentDescription = "${navigationItem.title}'s clicked"
                                    )
                                }

                                AnimatedVisibility(visible = index == bottomNavigationItemIndex) {
                                    Text(
                                        text = navigationItem.title,
                                        fontFamily = navigationItem.typeface,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { values ->
            NavGraphHost(navHostController = navHostController, values = values)
        }
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
        }
    }
}