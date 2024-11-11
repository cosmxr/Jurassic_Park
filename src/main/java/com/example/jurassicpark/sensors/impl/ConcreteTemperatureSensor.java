package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.TemperatureSensor;

public class ConcreteTemperatureSensor implements TemperatureSensor {
    private Dinosaur dinosaur;

    public ConcreteTemperatureSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @Override
    public void readData() {
        System.out.println("Midiendo temperatura de: " + dinosaur.getName());
    }

    @Override
    public void measureTemperature() {
        System.out.println("Temperatura corporal de: " + dinosaur.getName());
    }
}