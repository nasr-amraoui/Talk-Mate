package com.example.talkmate

import android.graphics.Bitmap

sealed class ChatUiEvents {
    data class UpdatePrompt(val newPrompt: String): ChatUiEvents()
    data class SentPrompt(val prompt: String, val bitmap: Bitmap?): ChatUiEvents()
    data class UpdateBitmap(val newBitmap: Bitmap?): ChatUiEvents()
}