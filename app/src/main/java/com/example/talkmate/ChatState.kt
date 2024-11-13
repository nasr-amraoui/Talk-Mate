package com.example.talkmate

import android.graphics.Bitmap
import com.example.talkmate.data.Chat

data class ChatState(
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)
