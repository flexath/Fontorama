package com.flexath.fontorama.utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.flexath.fontorama.ui.theme.Agbalumo
import com.flexath.fontorama.ui.theme.BebasNeue
import com.flexath.fontorama.ui.theme.DMSans
import com.flexath.fontorama.ui.theme.Kenia
import com.flexath.fontorama.ui.theme.NunitoSans
import com.flexath.fontorama.ui.theme.RobotoCondensed

data class TextResultStyle(
    var fontWeight: FontWeight,
    var fontFamily: FontFamily
)

val textResultStyleList = listOf(
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = RobotoCondensed
    ),
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = NunitoSans
    ),
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = DMSans
    ),
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = Kenia
    ),
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = BebasNeue
    ),
    TextResultStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = Agbalumo
    )
)