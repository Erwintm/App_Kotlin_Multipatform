package com.example.worldclocklite

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "WorldClockLite",
    ) {
        App()
    }
}