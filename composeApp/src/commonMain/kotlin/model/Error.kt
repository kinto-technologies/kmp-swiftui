package model

import kotlinx.serialization.Serializable

@Serializable
data class Error(val message: String)
