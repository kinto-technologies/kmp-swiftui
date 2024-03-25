package com.rasel.kmpswiftui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import chat.ChatApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatApp()
        }

        window.statusBarColor = 0xFFE6F0F2.toInt()
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ChatApp()
}
