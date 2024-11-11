package com.example.jurassicpark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class SensorController {
    private final File dataFile = new File("src/main/resources/sensor_data.json");

    @GetMapping("/monitor-data")
    public String monitorSensors() {
        try {
            return new String(Files.readAllBytes(dataFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }
}