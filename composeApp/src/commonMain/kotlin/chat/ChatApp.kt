package chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import model.Message
import repository.GeminiRepository
import theme.KmpSwiftUITheme
import timestampMs
import viewmodel.HomeViewModel

val viewModel = HomeViewModel(GeminiRepository())

@Composable
fun ChatApp(displayTextField: Boolean = true) {
    val state by viewModel.uiState.collectAsState()

    KmpSwiftUITheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Ask Gemini",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                    },
                    backgroundColor = MaterialTheme.colors.background,
                )
            }) {
            Box(modifier = Modifier.fillMaxSize().padding(it)) {
                Column {
                    Box(Modifier.weight(1f)) {
                        MessageList(state.messages)
                    }
                    if (displayTextField) {
                        ComposeInputField(
                            sendMessage = { text ->
                                viewModel.send(
                                    message = Message(user = myUser, timeMs = timestampMs(), text = text)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
