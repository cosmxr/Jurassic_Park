package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Clase que controla la vista de los dinosaurios mueertos
@RestController
public class DinosaurController {

    //Variable que representa el servicio de los sensores
    @Autowired
    private SensorService sensorService;

    //Metodo que muestra la vista de los dinosaurios muertos
    @GetMapping("/api/dinosaurios/muertos")
    public List<Dinosaur> getDeadDinosaurs() {
        return sensorService.getDeadDinosaurs();
    }
}