package com.example.worldclocklite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform