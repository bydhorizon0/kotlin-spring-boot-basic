package com.example.kopring.controller

import com.example.kopring.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/board")
@Controller
class BoardController @Autowired constructor(private val boardService: BoardService) {

    @GetMapping
    fun index(model: Model): String {
        val boardList = boardService.getAllBoards()
        model.addAttribute("boardList", boardList)

        return "board/index"
    }
}