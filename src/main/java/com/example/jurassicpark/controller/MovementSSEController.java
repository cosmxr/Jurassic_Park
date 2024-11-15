// MovementSSEController.java
package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class MovementSSEController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/movement-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Dinosaur>> streamMovementData() {
        return boardService.getDinosaurMovements();
    }
}