package com.example.jurassicpark.sensors.impl;

import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.dinosaurs.Dinosaur;

//Clase que representa un sensor de movimiento
public class ConcreteMovementSensor implements MovementSensor {

    //Atributo que representa el dinosaurio al que pertenece el sensor
    private Dinosaur dinosaur;

    //Constructor de la clase
    public ConcreteMovementSensor(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    //Metodo que lee los datos del sensor
    @Override
    public void readData() {
        System.out.println("Registrando movimientos de: " + dinosaur.getName());
    }

    //Metodo que detecta el movimiento del dinosaurio
    @Override
    public void detectMovement() {
        System.out.println("Movimiento detectado de: " + dinosaur.getName() + " en posición (" + dinosaur.getX() + ", " + dinosaur.getY() + ")");
    }
}