package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import model.GenerateContentRequest
import model.GenerateContentResponse

class ApiService {

    companion object {
        const val BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models"
    }

    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
        }
    }

    suspend fun getGeneratedContent(request: GenerateContentRequest): GenerateContentResponse {
        return client.post("$BASE_URL/gemini-pro:generateContent") {
            contentType(ContentType.Application.Json)
            url { parameters.append("key", "YOUR_API_KEY") }
            setBody(request)
        }.body<GenerateContentResponse>()
    }
}
