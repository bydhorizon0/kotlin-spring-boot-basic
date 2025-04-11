package com.example.kopring.domain.repository

import com.example.kopring.domain.board.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Board, String> {

}