// SensorService.java
package com.example.jurassicpark.service;

import com.example.jurassicpark.dinosaurs.*;
import com.example.jurassicpark.factory.SensorFactory;
import com.example.jurassicpark.sensors.HeartRateSensor;
import com.example.jurassicpark.sensors.HungerSensor;
import com.example.jurassicpark.sensors.MovementSensor;
import com.example.jurassicpark.sensors.TemperatureSensor;
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
import java.util.stream.Collectors;

@Service
public class SensorService {
    private static final Logger logger = LoggerFactory.getLogger(SensorService.class);
    private final SensorFactory sensorFactory;
    private final List<Dinosaur> dinosaurs = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File dataFile = new File("src/main/resources/sensor_data.json");
    private final List<Dinosaur> deadDinosaurs = new ArrayList<>();
    private BoardService boardService;

    public SensorService(SensorFactory sensorFactory) {
        this.sensorFactory = sensorFactory;
        generateDinosaurs();
        addDeadDinosaurs(); // Add this line
    }

    @PostConstruct
    public void init() {
        // Clean the file on startup
        try (FileWriter writer = new FileWriter(dataFile)) {
            writer.write("[]");
            logger.info("Data file initialized: {}", dataFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Error initializing data file", e);
        }
    }

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    private void generateDinosaurs() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int type = random.nextInt(4);
            switch (type) {
                case 0:
                    dinosaurs.add(new T_Rex("T-Rex " + i, "Enclosure " + (i % 10), true, false));
                    break;
                case 1:
                    dinosaurs.add(new Velociraptor("Velociraptor " + i, "Enclosure " + (i % 10), true, false));
                    break;
                case 2:
                    dinosaurs.add(new Stegosaurus("Stegosaurus " + i, "Enclosure " + (i % 10), false, false));
                    break;
                case 3:
                    dinosaurs.add(new Triceratops("Triceratops " + i, "Enclosure " + (i % 10), false, false));
                    break;
            }
        }
    }

    private void addDeadDinosaurs() {
        deadDinosaurs.add(new T_Rex("Dead T-Rex 1", "Enclosure 1", true, false));
        deadDinosaurs.add(new Velociraptor("Dead Velociraptor 1", "Enclosure 2", true, false));
    }

    public Flux<List<Dinosaur>> monitorSensors() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(tick -> {
                    dinosaurs.forEach(dinosaur -> {

                        dinosaur.updateAttributes();
                        MovementSensor movementSensor = sensorFactory.createMovementSensor(dinosaur);
                        TemperatureSensor temperatureSensor = sensorFactory.createTemperatureSensor(dinosaur);
                        HeartRateSensor heartRateSensor = sensorFactory.createHeartRateSensor(dinosaur);
                        HungerSensor hungerSensor = sensorFactory.createHungerSensor(dinosaur);

                        movementSensor.readData();
                        temperatureSensor.readData();
                        heartRateSensor.readData();
                        hungerSensor.readData();
                    });

                    try (FileWriter writer = new FileWriter(dataFile, false)) {
                        String jsonData = objectMapper.writeValueAsString(dinosaurs);
                        writer.write(jsonData);
                        logger.info("Sensor data written to file: {}", jsonData);
                    } catch (IOException e) {
                        logger.error("Error writing data to file", e);
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

    public void removeDinosaur(Dinosaur dinosaur) {
        dinosaurs.remove(dinosaur);
        logger.info("Dinosaur removed: " + dinosaur.getName());
        boardService.removeDinosaurFromBoard(dinosaur);
        updateJsonFile();
    }

    private void updateJsonFile() {
        try (FileWriter writer = new FileWriter(dataFile, false)) {
            String jsonData = objectMapper.writeValueAsString(dinosaurs);
            writer.write(jsonData);
            logger.info("Updated sensor data written to file: {}", jsonData);
        } catch (IOException e) {
            logger.error("Error updating data file", e);
        }
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
        return "default.jpg"; // Default image if no match is found
    }

    public List<Dinosaur> getDinosaurs() {
        return dinosaurs.stream()
                .filter(dinosaur -> !deadDinosaurs.contains(dinosaur))
                .collect(Collectors.toList());
    }

    public List<Dinosaur> getDeadDinosaurs() {
        return deadDinosaurs;
    }
}