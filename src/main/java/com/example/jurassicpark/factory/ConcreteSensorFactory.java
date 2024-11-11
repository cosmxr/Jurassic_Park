package com.example.jurassicpark.factory;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
import com.example.jurassicpark.sensors.HeartRateSensor;
import com.example.jurassicpark.sensors.impl.ConcreteMovementSensor;
import com.example.jurassicpark.sensors.impl.ConcreteTemperatureSensor;
import com.example.jurassicpark.sensors.impl.ConcreteHeartRateSensor;
import org.springframework.stereotype.Component;

@Component
public class ConcreteSensorFactory implements SensorFactory {
    @Override
    public MovementSensor createMovementSensor(Dinosaur dinosaur) {
        return new ConcreteMovementSensor(dinosaur);
    }

    @Override
    public TemperatureSensor createTemperatureSensor(Dinosaur dinosaur) {
        return new ConcreteTemperatureSensor(dinosaur);
    }

    @Override
    public HeartRateSensor createHeartRateSensor(Dinosaur dinosaur) {
        return new ConcreteHeartRateSensor(dinosaur);
    }
}