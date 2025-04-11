package com.example.kopring.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardServiceTest @Autowired constructor(val boardService: BoardService) {

    @Test
    fun getAllBoards() {
        boardService.getAllBoards()
            .forEach {
                println(it)
            }
    }

}