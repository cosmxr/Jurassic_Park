package com.example.jurassicpark.factory;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.HungerSensor;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
import com.example.jurassicpark.sensors.HeartRateSensor;

//Interfaz que representa una fabrica de sensores
public interface SensorFactory {
    MovementSensor createMovementSensor(Dinosaur dinosaur);
    TemperatureSensor createTemperatureSensor(Dinosaur dinosaur);
    HeartRateSensor createHeartRateSensor(Dinosaur dinosaur);
    HungerSensor createHungerSensor(Dinosaur dinosaur);
}