package com.example.jurassicpark.sensors;

//Interfaz que representa una fabrica de sensores
public interface SensorFactory {
    MovementSensor createMovementSensor();
    TemperatureSensor createTemperatureSensor();
    HeartRateSensor createHeartRateSensor();
}
