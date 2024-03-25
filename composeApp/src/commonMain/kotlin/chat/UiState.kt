package chat

import model.Message

data class UiState(
    val messages: List<Message> = emptyList()
)
