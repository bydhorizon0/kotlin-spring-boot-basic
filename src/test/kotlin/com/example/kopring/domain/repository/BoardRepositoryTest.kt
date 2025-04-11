package com.example.kopring.domain.repository

import com.example.kopring.domain.board.Board
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardRepositoryTest @Autowired constructor(
    val boardRepository: BoardRepository,
    val userRepository: AuthRepository) {

    @Test
    fun insertDummies() {
        val firstUser = userRepository.findAll()
            .first()

        (1..140).forEach {
            val board = Board(
                title = "Dummy title $it",
                content = "Dummy content $it",
                userEmail = firstUser.email,
            )

            boardRepository.save(board)
        }
    }
}