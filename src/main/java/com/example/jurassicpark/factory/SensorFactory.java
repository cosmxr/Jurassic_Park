package com.example.jurassicpark.factory;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
import com.example.jurassicpark.sensors.HeartRateSensor;

public interface SensorFactory {
    MovementSensor createMovementSensor(Dinosaur dinosaur);
    TemperatureSensor createTemperatureSensor(Dinosaur dinosaur);
    HeartRateSensor createHeartRateSensor(Dinosaur dinosaur);
}