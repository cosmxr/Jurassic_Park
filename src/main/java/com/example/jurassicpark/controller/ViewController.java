package com.example.jurassicpark.controller;

import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Controller
public class ViewController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/monitor")
    public String monitorView() {
        return "monitor";
    }
}

