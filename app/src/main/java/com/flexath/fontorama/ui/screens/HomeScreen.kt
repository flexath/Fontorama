package com.flexath.fontorama.ui.screens

import android.content.ClipData
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.flexath.fontorama.activities.changeColorWithDisplayMode
import com.flexath.fontorama.ui.theme.ColorDarkGray
import com.flexath.fontorama.ui.theme.ColorLightGray
import com.flexath.fontorama.ui.theme.LightColorScheme
import com.flexath.fontorama.ui.theme.RobotoCondensed
import com.flexath.fontorama.ui.theme.fontFamily
import com.flexath.fontorama.utils.textResultStyleList
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    values: PaddingValues
) {

    Column(
        modifier = Modifier
            .background(
                color = changeColorWithDisplayMode(
                    darkColor = ColorDarkGray,
                    lightColor = LightColorScheme.background
                )
            )
            .padding(values)
            .fillMaxSize()
            .padding(bottom = 20.dp)
    ) {
        HomeScreenSetUp()
    }
}

@Composable
fun HomeScreenSetUp() {

    var text by rememberSaveable {
        mutableStateOf("Aung Thiha")
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = changeColorWithDisplayMode(
                darkColor = ColorLightGray,
                lightColor = Color.White
            )
        )

    ) {

        Text(
            text = "Enter your text",
            fontSize = 24.sp,
            fontFamily = RobotoCondensed,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = changeColorWithDisplayMode(
                darkColor = Color.White,
                lightColor = Color.DarkGray
            ),
            modifier = Modifier
                .background(
                    color = changeColorWithDisplayMode(
                        darkColor = ColorLightGray,
                        lightColor = LightColorScheme.surface
                    )
                )
                .padding(top = 20.dp, bottom = 10.dp)
                .fillMaxWidth()

        )

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = {
                Text(
                    text = "Type or Copy/Paste",
                    fontSize = 16.sp,
                    fontFamily = RobotoCondensed,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    color = changeColorWithDisplayMode(
                        darkColor = Color.White,
                        lightColor = Color.DarkGray
                    )
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            minLines = 5,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = changeColorWithDisplayMode(
                    darkColor = ColorDarkGray,
                    lightColor = LightColorScheme.surface
                ),
                unfocusedIndicatorColor = changeColorWithDisplayMode(
                    darkColor = ColorDarkGray,
                    lightColor = LightColorScheme.surface
                ),
                cursorColor = changeColorWithDisplayMode(
                    darkColor = Color.White,
                    lightColor = Color.DarkGray
                ),
                focusedContainerColor = changeColorWithDisplayMode(
                    darkColor = ColorLightGray,
                    lightColor = LightColorScheme.surface
                ),
                unfocusedContainerColor = changeColorWithDisplayMode(
                    darkColor = ColorLightGray,
                    lightColor = LightColorScheme.surface
                ),
                focusedTextColor = changeColorWithDisplayMode(
                    darkColor = Color.White,
                    lightColor = Color.DarkGray
                ),
                unfocusedTextColor = changeColorWithDisplayMode(
                    darkColor = Color.White,
                    lightColor = Color.DarkGray
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = changeColorWithDisplayMode(
                        darkColor = ColorLightGray,
                        lightColor = LightColorScheme.surface
                    )
                )
                .wrapContentHeight(),
        )
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = changeColorWithDisplayMode(
                darkColor = ColorLightGray,
                lightColor = Color.White
            )
        )
    ) {

        Text(
            text = "Bold",
            fontSize = 20.sp,
            fontFamily = RobotoCondensed,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = changeColorWithDisplayMode(
                darkColor = Color.White,
                lightColor = Color.DarkGray
            ),
            modifier = Modifier
                .background(
                    color = changeColorWithDisplayMode(
                        darkColor = ColorLightGray,
                        lightColor = LightColorScheme.surface
                    )
                )
                .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
                .fillMaxWidth()

        )

        LazyColumn(
            modifier = Modifier
                .background(
                    color = changeColorWithDisplayMode(
                        darkColor = ColorLightGray,
                        lightColor = Color.White
                    )
                )
                .padding(bottom = 20.dp)

        ) {
            items(textResultStyleList) {
                val context = LocalContext.current

                val selectedText by remember { mutableStateOf(AnnotatedString(text)) }

                SelectionContainer {
                    Text(
                        text = text,
                        fontSize = 30.sp,
                        fontFamily = it.fontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        lineHeight = 40.sp,
                        color = changeColorWithDisplayMode(
                            darkColor = Color.White,
                            lightColor = Color.DarkGray
                        ),
                        modifier = Modifier
                            .background(
                                color = changeColorWithDisplayMode(
                                    darkColor = ColorLightGray,
                                    lightColor = LightColorScheme.surface
                                )
                            )
                            .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
                            .fillMaxWidth()
                            .clickable {
                                copyTextToClipboard(context, text)

                                Toast
                                    .makeText(context, selectedText.text, Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                }
            }
        }
    }
}

private fun copyTextToClipboard(context: Context, text:String) {
    val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
    val clipData = ClipData.newPlainText("text", text)
    clipboardManager.setPrimaryClip(clipData)

    Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_LONG).show()
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navHostController = rememberNavController(),
        values = PaddingValues(20.dp)
    )
}