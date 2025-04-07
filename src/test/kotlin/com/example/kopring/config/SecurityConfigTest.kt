package com.example.kopring.config

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Test
    fun `패스워드_암호화`() {
        val encode = passwordEncoder.encode("123123")
        println(encode)
    }
}