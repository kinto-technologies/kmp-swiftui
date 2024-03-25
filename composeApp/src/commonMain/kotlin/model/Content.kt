package model

import kotlinx.serialization.Serializable

@Serializable
data class Content(val parts: List<Part>)
