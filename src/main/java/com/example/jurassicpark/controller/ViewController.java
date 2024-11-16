package com.example.jurassicpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Clase que controla las vistas
@Controller
public class ViewController {

    //Metodo que muestra la vista de inicio
    @GetMapping("/")
    public String homeView() {
        return "home";
    }

    //Metodo que muestra la vista de la tabla de dinosaurios
    @GetMapping("/monitor")
    public String monitorView() {
        return "monitor";
    }

    //Metodo que muestra la vista de los dinosaurios
    @GetMapping("/dinosaurios")
    public String dinosauriosView() {
        return "dinosaurios";
    }

    //Metodo que muestra la vista de los dinosaurios de la enfermeria
    @GetMapping("/enfermeria")
    public String enfermeriaView() {
        return "enfermeria";
    }

}
