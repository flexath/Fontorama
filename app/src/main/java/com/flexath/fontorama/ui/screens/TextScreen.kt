package com.flexath.fontorama.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TextScreen(navHostController: NavHostController, values: PaddingValues) {
    LazyColumn(
        content = {
            items(50) {
                Text(
                    text = "item $it",
                    modifier = Modifier.padding(10.dp)
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(values)
    )
}