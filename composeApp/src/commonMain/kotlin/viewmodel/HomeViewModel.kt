package viewmodel

import chat.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import model.Message
import model.User
import repository.GeminiRepository
import theme.ChatColors
import timestampMs

class HomeViewModel(
    private val repository: GeminiRepository,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(
        UiState(
            messages = listOf(
                Message(
                    user = User("Gemini", color = ChatColors.GEMINI_COLOR, picture = "gemini.xml"),
                    timeMs = timestampMs(),
                    text = "Hello! I'm Gemini. Your digital assistance. How can I help you?"
                )
            )
        )
    )
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun send(message: Message) {
        viewModelScope.launch {
            promptToGemini(message.text)
            _uiState.value = uiState.value.copy(
                messages = uiState.value.messages + message
            )
        }
    }

    private fun promptToGemini(text: String) {
        viewModelScope.launch {
            val content = repository.generateContent(promptText = text)
            if (content.isBlank()) return@launch

            val message = Message(
                User("Gemini", color = ChatColors.GEMINI_COLOR, picture = "gemini.xml"),
                timeMs = timestampMs(),
                text = content
            )
            _uiState.value = uiState.value.copy(messages = uiState.value.messages + message)
        }
    }
}
