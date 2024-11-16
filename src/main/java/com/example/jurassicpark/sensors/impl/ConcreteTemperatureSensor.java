package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.TemperatureSensor;

//Clase que representa un sensor de temperatura
public class ConcreteTemperatureSensor implements TemperatureSensor {

    //Atributo que representa el dinosaurio al que pertenece el sensor
    private Dinosaur dinosaur;

    //Constructor de la clase
    public ConcreteTemperatureSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    //Metodo que lee los datos del sensor
    @Override
    public void readData() {
        System.out.println("Midiendo temperatura de: " + dinosaur.getName());
    }

    //Metodo que mide la temperatura del dinosaurio
    @Override
    public void measureTemperature() {
        System.out.println("Temperatura corporal de: " + dinosaur.getName());
    }
}