package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinosaurInfoController {

    @Autowired
    private SensorService sensorService;

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