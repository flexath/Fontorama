package com.flexath.fontorama.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.flexath.fontorama.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_extra_light, FontWeight.ExtraLight),
    Font(R.font.nunito_sans_light, FontWeight.Light),
    Font(R.font.nunito_sans_regular, FontWeight.Normal),
    Font(R.font.nunito_sans_medium, FontWeight.Medium),
    Font(R.font.nunito_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.nunito_sans_bold, FontWeight.Bold),
    Font(R.font.nunito_sans_extra_bold, FontWeight.ExtraBold),
    Font(R.font.nunito_sans_black, FontWeight.Black)
)

val DMSans = FontFamily(
    Font(R.font.dm_sans_extra_light, FontWeight.ExtraLight),
    Font(R.font.dm_sans_light, FontWeight.Light),
    Font(R.font.dm_sans_regular, FontWeight.Normal),
    Font(R.font.dm_sans_medium, FontWeight.Medium),
    Font(R.font.dm_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.dm_sans_bold, FontWeight.Bold),
    Font(R.font.dm_sans_extra_bold, FontWeight.ExtraBold),
    Font(R.font.dm_sans_black, FontWeight.Black)
)

val Roboto = FontFamily(
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_black, FontWeight.Black)
)

val RobotoCondensed = FontFamily(
    Font(R.font.roboto_condensed_light, FontWeight.Light),
    Font(R.font.roboto_condensed_regular, FontWeight.Normal),
    Font(R.font.roboto_condensed_medium, FontWeight.Medium),
    Font(R.font.roboto_condensed_semi_bold, FontWeight.SemiBold),
    Font(R.font.roboto_condensed_bold, FontWeight.Bold),
    Font(R.font.roboto_condensed_extra_bold, FontWeight.ExtraBold),
    Font(R.font.roboto_condensed_black, FontWeight.Black)
)

val Kenia = FontFamily(
    Font(R.font.kenia_regular, FontWeight.Normal)
)

val BebasNeue = FontFamily(
    Font(R.font.bebas_neue_regular, FontWeight.Normal)
)

val Agbalumo = FontFamily(
    Font(R.font.agbalumo_regular, FontWeight.Normal)
)

val Anton = FontFamily(
    Font(R.font.anton_regular, FontWeight.Normal)
)



val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Anton")

val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Bold)
)