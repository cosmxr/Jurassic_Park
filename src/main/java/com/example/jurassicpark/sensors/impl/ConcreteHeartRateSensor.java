package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.HeartRateSensor;

//Clase que representa un sensor de ritmo cardíaco
public class ConcreteHeartRateSensor implements HeartRateSensor {

    //Atributo que representa el dinosaurio al que pertenece el sensor
    private Dinosaur dinosaur;

    //Constructor de la clase
    public ConcreteHeartRateSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    //Metodo que lee los datos del sensor
    @Override
    public void readData() {
        System.out.println("Leyendo ritmo cardiaco de:  " + dinosaur.getName());
    }

    //Metodo que monitorea el ritmo cardiaco del dinosaurio
    @Override
    public void monitorHeartRate() {
        System.out.println("Ritmo cardiaco de: " + dinosaur.getName());
    }
}