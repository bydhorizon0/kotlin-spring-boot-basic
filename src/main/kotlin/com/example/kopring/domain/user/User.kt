package com.example.kopring.domain.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class User(
    @Id
    val email: String,
    val password: String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)