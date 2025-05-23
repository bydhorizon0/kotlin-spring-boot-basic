package com.example.kopring.config

import com.example.kopring.service.security.UserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(private val userDetailService: UserDetailService) {

    @Bean
    fun bcryptPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(): UserDetailsService = userDetailService

    /**
     * Spring Boot 3.x / Spring Security 6.x부터는
     * WebSecurityConfigurerAdapter 가 deprecated되면서,
     * 기존에 자동으로 처리되던 AuthenticationManager 설정을 직접 해줘야 해.
     */
    @Bean
    fun authenticationManager(
        passwordEncoder: PasswordEncoder,
        userDetailService: UserDetailService
    ): AuthenticationManager {
        val provider = DaoAuthenticationProvider().apply {
            setUserDetailsService(userDetailService)
            setPasswordEncoder(passwordEncoder)
        }

        return ProviderManager(provider)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/",
                    "/css/**",
                    "/js/**",
                    "/bootstrap/**",
                    "/auth/signup",
                    "/auth/signup/**",
                    "/auth/login"
                )
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .formLogin {
                it.loginPage("/auth/login") // 커스텀 로그인 페이지 경로
                    .loginProcessingUrl("/auth/login") // 폼에서 POST로 로그인 처리할 URL
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            }.logout {
                it.logoutUrl("/auth/logout") // 로그아웃 요청 URL
                    .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID") // 세션 쿠키 삭제
            }.build()
    }
}