package com.example.talkmate.data

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {
    private const val API_KEY = "AIzaSyCsOBJGQEMlm_BcAMzyV1ydly2lMJcHB4A"

    // Generating Responses Based on Text Only
    suspend fun getResponse(prompt: String) : Chat{
        val generativeModel = GenerativeModel(modelName = "gemini-pro", apiKey = API_KEY)

        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(prompt)
            }
            return Chat(
                prompt = response.text ?: "Unexpected error!",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "Unexpected error!",
                bitmap = null,
                isFromUser = false
            )
        }
    }

    // Generating Responses Based on Text and Images
    suspend fun getResponseWithBitmap(prompt: String, bitmap: Bitmap) : Chat{
        val inputContent = content {
            text(prompt)
            image(bitmap)
        }

        val generativeModel = GenerativeModel(modelName = "gemini-pro-vision", apiKey = API_KEY)

        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(inputContent)
            }
            return Chat(
                prompt = response.text ?: "Unexpected error!",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "Unexpected error!",
                bitmap = null,
                isFromUser = false
            )
        }
    }
}