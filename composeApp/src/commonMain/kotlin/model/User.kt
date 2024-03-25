package model

import androidx.compose.ui.graphics.Color
import utils.ColorProvider

data class User(
    val name: String,
    val color: Color = ColorProvider.getColor(),
    val picture: String?
)
