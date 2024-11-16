package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Clase que controla la vista de la información de los dinosaurios
@RestController
public class DinosaurInfoController {

    //Variable que representa el servicio de los sensores
    @Autowired
    private SensorService sensorService;

    //Metodo que muestra la vista de la información de los dinosaurios
    @GetMapping("/dinosaur-info")
    public String getDinosaurInfo(@RequestParam String name) {
        Dinosaur dinosaur = sensorService.getDinosaurByName(name);
        if (dinosaur != null) {
            return dinosaur.displayInfo();
        } else {
            return "Dinosaur not found";
        }
    }
}