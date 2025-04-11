package com.example.kopring.domain.board

import com.example.kopring.dto.BoardResponse
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("boards")
data class Board(
    @Id val seq: Long? = null,
    val title: String,
    val content: String,
    val userEmail: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    fun toBoardResponse() = BoardResponse(seq!!, title, content, userEmail, createdAt)
}
