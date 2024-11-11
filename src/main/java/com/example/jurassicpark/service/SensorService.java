package com.example.jurassicpark.service;

import com.example.jurassicpark.dinosaurs.*;
import com.example.jurassicpark.factory.SensorFactory;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
import com.example.jurassicpark.sensors.HeartRateSensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SensorService {
    private static final Logger logger = LoggerFactory.getLogger(SensorService.class);
    private final SensorFactory sensorFactory;
    private final List<Dinosaur> dinosaurs = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File dataFile = new File("src/main/resources/sensor_data.json");

    public SensorService(SensorFactory sensorFactory) {
        this.sensorFactory = sensorFactory;
        generateDinosaurs();
    }

    @PostConstruct
    public void init() {
        // Clean the file on startup
        try (FileWriter writer = new FileWriter(dataFile)) {
            writer.write("[]");
            logger.info("Data file inicializado: {}", dataFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Error inicializando data file", e);
        }
    }

    private void generateDinosaurs() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int type = random.nextInt(4);
            switch (type) {
                case 0:
                    dinosaurs.add(new T_Rex("T-Rex " + i, "" + (i % 10), true));
                    break;
                case 1:
                    dinosaurs.add(new Velociraptor("Velociraptor " + i, "" + (i % 10),true));
                    break;
                case 2:
                    dinosaurs.add(new Stegosaurus("Stegosaurus " + i, "" + (i % 10),false));
                    break;
                case 3:
                    dinosaurs.add(new Triceratops("Triceratops " + i, "" + (i % 10),false));
                    break;
            }
        }
    }

    public Flux<List<Dinosaur>> monitorSensors() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(tick -> {
                    dinosaurs.forEach(dinosaur -> {
                        dinosaur.updateAttributes();
                        MovementSensor movementSensor = sensorFactory.createMovementSensor(dinosaur);
                        TemperatureSensor temperatureSensor = sensorFactory.createTemperatureSensor(dinosaur);
                        HeartRateSensor heartRateSensor = sensorFactory.createHeartRateSensor(dinosaur);

                        movementSensor.readData();
                        temperatureSensor.readData();
                        heartRateSensor.readData();
                    });

                    try (FileWriter writer = new FileWriter(dataFile, false)) {
                        String jsonData = objectMapper.writeValueAsString(dinosaurs);
                        writer.write(jsonData);
                        logger.info("Sensor data escrita al archivo: {}", jsonData);
                    } catch (IOException e) {
                        logger.error("Errror escribiendo la informacion al archivo", e);
                    }
                    return dinosaurs;
                });
    }
    public Dinosaur getDinosaurByName(String name) {
        return dinosaurs.stream()
                .filter(dinosaur -> dinosaur.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public String getImageName(String dinosaurName) {
        if (dinosaurName.toLowerCase().contains("t-rex")) {
            return "t-rex.jpg";
        } else if (dinosaurName.toLowerCase().contains("velociraptor")) {
            return "velociraptor.jpg";
        } else if (dinosaurName.toLowerCase().contains("stegosaurus")) {
            return "stegosaurus.jpg";
        } else if (dinosaurName.toLowerCase().contains("triceratops")) {
            return "triceratops.jpg";
        }
        return "default.jpg"; // Imagen por defecto si no se encuentra coincidencia
    }
}