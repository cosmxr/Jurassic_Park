package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.HeartRateSensor;

public class ConcreteHeartRateSensor implements HeartRateSensor {
    private Dinosaur dinosaur;

    public ConcreteHeartRateSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @Override
    public void readData() {
        System.out.println("Leyendo ritmo cardiaco de:  " + dinosaur.getName());
    }

    @Override
    public void monitorHeartRate() {
        System.out.println("Ritmo cardiaco de: " + dinosaur.getName());
    }
}