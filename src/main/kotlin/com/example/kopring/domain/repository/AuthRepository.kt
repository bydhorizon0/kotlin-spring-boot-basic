package com.example.kopring.domain.repository

import com.example.kopring.domain.user.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface AuthRepository : CrudRepository<User, String> {

    @Query("INSERT users (email, password) VALUES (:email, :password)")
    fun insert(
        @Param("email") email: String,
        @Param("password") password: String,
    )
}