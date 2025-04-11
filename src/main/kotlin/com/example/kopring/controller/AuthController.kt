package com.example.kopring.controller

import com.example.kopring.dto.SignupForm
import com.example.kopring.service.AuthService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/auth")
@Controller
class AuthController(private val authService: AuthService) {

    @GetMapping("/signup")
    fun signup(model: Model): String {
        model.addAttribute("signupForm", SignupForm())
        return "auth/signup"
    }

    @PostMapping("/signup")
    fun signup(
        @Valid @ModelAttribute signupForm: SignupForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (!signupForm.isPasswordMatch()) {
            bindingResult.rejectValue("confirmPassword", "password.mismatch", "비밀번호가 일치하지 않습니다.")
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("signupForm", signupForm)
            return "auth/signup"
        }

        authService.signup(signupForm)
        return "redirect:/login"
    }

    @GetMapping("/login")
    fun login() = "auth/login"


}