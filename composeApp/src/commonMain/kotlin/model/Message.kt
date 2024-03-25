package model

import kotlin.random.Random

data class Message private constructor(
    val user: User,
    val timeMs: Long,
    val text: String,
    val id: Long
) {
    constructor(
        user: User,
        timeMs: Long,
        text: String
    ) : this(
        user = user,
        timeMs = timeMs,
        text = text,
        id = Random.nextLong()
    )
}
