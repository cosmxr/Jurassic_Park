package com.example.jurassicpark.sensors;

public interface SensorFactory {
    MovementSensor createMovementSensor();
    TemperatureSensor createTemperatureSensor();
    HeartRateSensor createHeartRateSensor();
}
