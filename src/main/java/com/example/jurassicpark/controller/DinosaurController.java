// DinosaurController.java
package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DinosaurController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/api/dinosaurios/muertos")
    public List<Dinosaur> getDeadDinosaurs() {
        return sensorService.getDeadDinosaurs();
    }
}