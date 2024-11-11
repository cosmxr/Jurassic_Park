package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.dinosaurs.*;

public class ConcreteMovementSensor implements MovementSensor {
    private Dinosaur dinosaur;

    public ConcreteMovementSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @Override
    public void readData() {
        System.out.println("Registrando movimientos de: " + dinosaur.getName());
    }

    @Override
    public void detectMovement() {
        System.out.println("Movimineto detectado de: " + dinosaur.getName());
    }
}