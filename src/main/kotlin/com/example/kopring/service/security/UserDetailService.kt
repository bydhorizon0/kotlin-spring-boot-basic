package com.example.kopring.service.security

import com.example.kopring.domain.repository.AuthRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserDetailService(
    private val authRepository: AuthRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = authRepository.findById(email).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "이메일에 해당하는 계정이 없습니다.")
        }

        return User
            .withUsername(user.email)
            .password(user.password)
            .roles("USER")
            .build()
    }
}