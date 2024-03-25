
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import chat.ChatApp
import chat.myUser
import chat.viewModel
import model.Message
import platform.UIKit.UIViewController

fun ComposeEntryPoint(): UIViewController =
    ComposeUIViewController {
        Column(
            Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChatApp(displayTextField = false)
        }
    }

fun sendMessage(text: String) {
    viewModel.send(Message(user = myUser, timeMs = timestampMs(), text = text))
}
