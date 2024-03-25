package theme

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun KmpSwiftUITheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            surface = Color(0xFFCC99FF),
            background = Color(0xFFE6F0F2),
        ),
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(letterSpacing = 0.sp)) {
            content()
        }
    }
}
