package com.example.kopring.service

import com.example.kopring.domain.repository.AuthRepository
import com.example.kopring.domain.user.User
import com.example.kopring.dto.SignupForm
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthService(
    private val authRepository: AuthRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun signup(signupForm: SignupForm) {
        val encodedPassword = passwordEncoder.encode(signupForm.password)
        authRepository.insert(signupForm.email, encodedPassword)
    }

    fun loginUser(signupForm: SignupForm) {
        val dbUser = getUserByEmail(signupForm.email)
        val encodedPassword = passwordEncoder.encode(signupForm.password)

        if (passwordEncoder.matches(dbUser.password, encodedPassword)) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.")
        }
    }

    private fun getUserByEmail(email: String): User {
        return authRepository.findById(email).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "이메일에 해당하는 계정이 없습니다.")
        }
    }
}