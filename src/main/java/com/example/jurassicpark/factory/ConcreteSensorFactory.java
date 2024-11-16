// ConcreteSensorFactory.java
package com.example.jurassicpark.factory;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
import com.example.jurassicpark.sensors.HeartRateSensor;
import com.example.jurassicpark.sensors.HungerSensor;
import com.example.jurassicpark.sensors.impl.ConcreteMovementSensor;
import com.example.jurassicpark.sensors.impl.ConcreteTemperatureSensor;
import com.example.jurassicpark.sensors.impl.ConcreteHeartRateSensor;
import com.example.jurassicpark.sensors.impl.ConcreteHungerSensor;
import org.springframework.stereotype.Component;

//Clase que representa una fabrica de sensores concretos
@Component
public class ConcreteSensorFactory implements SensorFactory {

    //Metodo que crea un sensor de movimiento
    @Override
    public MovementSensor createMovementSensor(Dinosaur dinosaur) {
        return new ConcreteMovementSensor(dinosaur);
    }

    //Metodo que crea un sensor de temperatura
    @Override
    public TemperatureSensor createTemperatureSensor(Dinosaur dinosaur) {
        return new ConcreteTemperatureSensor(dinosaur);
    }

    //Metodo que crea un sensor de ritmo cardiaco
    @Override
    public HeartRateSensor createHeartRateSensor(Dinosaur dinosaur) {
        return new ConcreteHeartRateSensor(dinosaur);
    }

    //Metodo que crea un sensor de hambre
    @Override
    public HungerSensor createHungerSensor(Dinosaur dinosaur) {
        return new ConcreteHungerSensor(dinosaur);
    }
}