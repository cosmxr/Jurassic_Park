package com.example.jurassicpark.controller;

import com.example.jurassicpark.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Clase que controla la vista de la tabla de dinosaurios
@Controller
public class BoardController {

    //Variable que representa el servicio de la tabla de dinosaurios
    @Autowired
    private BoardService boardService;

    //Metodo que muestra la vista de la tabla de dinosaurios
    @GetMapping("/board")
    public String boardView(Model model) {
        model.addAttribute("board", boardService.getBoard());
        return "board";
    }
}