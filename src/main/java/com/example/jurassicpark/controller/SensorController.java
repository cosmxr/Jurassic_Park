package com.example.jurassicpark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//Clase que controla la vista de los sensores
@RestController
public class SensorController {

    //Variable que representa el archivo de los datos de los sensores
    private final File dataFile = new File("src/main/resources/sensor_data.json");

    //Metodo que muestra la vista de los sensores
    @GetMapping("/monitor-data")
    public String monitorSensors() {
        try {
            //Devuelve los datos de los sensores
            return new String(Files.readAllBytes(dataFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }
}