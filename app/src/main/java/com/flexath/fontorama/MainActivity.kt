package com.flexath.fontorama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.flexath.fontorama.ui.theme.DarkColorScheme
import com.flexath.fontorama.ui.theme.DarkPrimaryColor
import com.flexath.fontorama.ui.theme.FontoramaTheme
import com.flexath.fontorama.ui.theme.LightColorScheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FontoramaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if(isSystemInDarkTheme()) {
                        DarkColorScheme.background
                    } else {
                        LightColorScheme.background
                    }
                ) {
                    if (isSystemInDarkTheme()) {
                        ChangeStatusBarColor(DarkColorScheme.background, false, DarkColorScheme.background)
                    } else {
                        ChangeStatusBarColor(LightColorScheme.background, true, LightColorScheme.background)
                    }

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

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    FontoramaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChangeStatusBarColor(Color.Transparent, true,Color.Black)
        }
    }
}