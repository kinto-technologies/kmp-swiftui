package model

import kotlinx.serialization.Serializable

@Serializable
data class GenerateContentRequest(val contents: Content)
