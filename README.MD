```text
src
└── main
    └── kotlin
        └── com.example.app
            ├── config
            │   └── MyBatisConfig.kt         // MyBatis 설정 (필요 시)
            │
            ├── controller
            │   └── UserController.kt
            │
            ├── domain
            │   ├── user
            │   │   ├── model
            │   │   │   └── User.kt         // Entity (Spring Data JDBC용)
            │   │   ├── repository
            │   │   │   └── UserRepository.kt  // Spring Data JDBC repository
            │   │   └── mapper
            │   │       └── UserMapper.kt   // MyBatis 인터페이스
            │
            ├── dto
            │   └── UserDto.kt
            │
            ├── service
            │   └── UserService.kt
            │
            └── Application.kt
```