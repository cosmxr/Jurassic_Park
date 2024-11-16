// ConcreteHungerSensor.java
package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.HungerSensor;

//Clase que representa un sensor de hambre
public class ConcreteHungerSensor implements HungerSensor {

    //Atributo que representa el dinosaurio al que pertenece el sensor
    private Dinosaur dinosaur;

    //Constructor de la clase
    public ConcreteHungerSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    //Metodo que lee los datos del sensor
    @Override
    public void readData() {
        System.out.println("Midiendo nivel de hambre de: " + dinosaur.getName());
    }

    //Metodo que mide el nivel de hambre del dinosaurio
    @Override
    public void measureHunger() {
        System.out.println("Nivel de hambre de: " + dinosaur.getName() + " es " + dinosaur.getHungerLevel() + "%");
    }
}