package com.example.kopring.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SignupForm(
    @field:NotBlank(message = "이메일은 필수입니다.")
    @field:Email(message = "이메일 형식이 아닙니다.")
    val email: String = "",

    @field:NotBlank(message = "비밀번호는 필수입니다.")
    @field:Size(min = 6, message = "비밀번호는 최소 6자 이상입니다.")
    val password: String = "",

    @field:NotBlank(message = "비밀번호는 필수입니다.")
    val confirmPassword: String = ""
) {
    fun isPasswordMatch(): Boolean = password == confirmPassword
}

/*
    Kotlin에서는 애노테이션이 필드에 적용되도록 prefix로 @field: 를 꼭 붙여야 한다.
 */