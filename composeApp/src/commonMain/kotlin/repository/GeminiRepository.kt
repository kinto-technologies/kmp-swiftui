package repository

import data.ApiService
import model.Content
import model.GenerateContentRequest
import model.Part

class GeminiRepository {

    private val geminiApi = ApiService()

    suspend fun generateContent(promptText: String): String {
        val part = Part(text = promptText)
        val contents = Content(listOf(part))
        val request = GenerateContentRequest(contents)

        val response = geminiApi.getGeneratedContent(request = request)
        val content = response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text ?: ""

        return content
    }
}
