package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

//Clase que controla los eventos de los sensores
@RestController
public class SensorSSEController {

    //Variable que representa el servicio de los sensores
    @Autowired
    private SensorService sensorService;

    //Metodo que muestra la vista de los eventos de los sensores
    @GetMapping(value = "/sensor-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Dinosaur>> streamSensorData() {
        return sensorService.monitorSensors();
    }
}