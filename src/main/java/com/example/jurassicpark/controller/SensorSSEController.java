package com.example.jurassicpark.controller;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class SensorSSEController {

    @Autowired
    private SensorService sensorService;

    @GetMapping(value = "/sensor-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Dinosaur>> streamSensorData() {
        return sensorService.monitorSensors();
    }
}