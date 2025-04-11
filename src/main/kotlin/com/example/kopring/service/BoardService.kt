package com.example.kopring.service

import com.example.kopring.domain.board.Board
import com.example.kopring.domain.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService @Autowired constructor(private val boardRepository: BoardRepository) {

    fun getAllBoards(): Iterable<Board> = boardRepository.findAll()
}