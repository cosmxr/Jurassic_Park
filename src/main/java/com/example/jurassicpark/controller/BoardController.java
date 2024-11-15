// BoardController.java
package com.example.jurassicpark.controller;

import com.example.jurassicpark.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String boardView(Model model) {
        model.addAttribute("board", boardService.getBoard());
        return "board";
    }
}