package com.example.kopring.domain.repository

import com.example.kopring.domain.user.User
import org.springframework.data.repository.CrudRepository

interface AuthRepository : CrudRepository<User, String> {

}