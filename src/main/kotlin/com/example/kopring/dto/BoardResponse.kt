package com.example.kopring.dto

import java.time.LocalDateTime

data class BoardResponse(
    val seq: Long,
    val title: String,
    val content: String,
    val userEmail: String,
    val createdAt: LocalDateTime,
)
