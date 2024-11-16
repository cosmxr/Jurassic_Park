package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

//Clase que controla la vista de los movimientos de los dinosaurios
@RestController
public class MovementSSEController {

    //Variable que representa el servicio de la tabla de dinosaurios
    @Autowired
    private BoardService boardService;

    //Metodo que muestra la vista de los movimientos de los dinosaurios
    @GetMapping(value = "/movement-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Dinosaur>> streamMovementData() {
        return boardService.getDinosaurMovements();
    }
}