// ConcreteHungerSensor.java
package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.HungerSensor;

public class ConcreteHungerSensor implements HungerSensor {
    private Dinosaur dinosaur;

    public ConcreteHungerSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @Override
    public void readData() {
        System.out.println("Midiendo nivel de hambre de: " + dinosaur.getName());
    }

    @Override
    public void measureHunger() {
        System.out.println("Nivel de hambre de: " + dinosaur.getName() + " es " + dinosaur.getHungerLevel() + "%");
    }
}