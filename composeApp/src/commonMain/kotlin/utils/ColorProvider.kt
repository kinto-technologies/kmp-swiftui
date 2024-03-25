package utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random
import kotlin.random.nextInt

object ColorProvider {
    private val colors = mutableListOf(
        0xFFEA3468,
        0xFFB634EA,
        0xFF349BEA,
    )

    private val allColors = colors.toList()

    fun getColor(): Color {
        if(colors.size == 0) {
            colors.addAll(allColors)
        }
        val idx = Random.nextInt(colors.indices)
        val color = colors[idx]
        colors.removeAt(idx)
        return Color(color)
    }
}
