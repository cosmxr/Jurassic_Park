package com.example.jurassicpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String homeView() {
        return "home";
    }

    @GetMapping("/monitor")
    public String monitorView() {
        return "monitor";
    }

    @GetMapping("/dinosaurios")
    public String dinosauriosView() {
        return "dinosaurios";
    }

    @GetMapping("/enfermeria")
    public String enfermeriaView() {
        return "enfermeria";
    }
}