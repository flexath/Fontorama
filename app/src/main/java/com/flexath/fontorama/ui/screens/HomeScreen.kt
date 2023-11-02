package com.flexath.fontorama.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.flexath.fontorama.activities.changeColorWithDisplayMode
import com.flexath.fontorama.ui.theme.DarkColorScheme
import com.flexath.fontorama.ui.theme.LightColorScheme
import com.flexath.fontorama.ui.theme.NunitoSans

@Composable
fun HomeScreen(navHostController: NavHostController, values: PaddingValues) {
    Surface (
        modifier = Modifier
            .background(
                color = changeColorWithDisplayMode(
                    darkColor = DarkColorScheme.background,
                    lightColor = LightColorScheme.background
                )
            )
            .padding(values)
            .fillMaxSize()
    ) {
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 250.dp)
                .wrapContentHeight()

        ) {
            Text(
                text = "Enter your text",
                fontSize = 24.sp,
                fontFamily = NunitoSans,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )

        }
    }
}