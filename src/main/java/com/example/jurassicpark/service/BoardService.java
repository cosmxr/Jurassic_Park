// BoardService.java
package com.example.jurassicpark.service;

import com.example.jurassicpark.dinosaurs.Dinosaur;
import com.example.jurassicpark.sensors.impl.ConcreteMovementSensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Clase que representa el servicio del tablero
@Service
public class BoardService {

    //Variables
    private final Cell[][] board = new Cell[7][7];
    private final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File movementFile = new File("src/main/resources/movement_data.json");
    private final Sinks.Many<List<Dinosaur>> sink = Sinks.many().replay().latest();
    private final SensorService sensorService;

    //Constructor que inicializa el tablero con celdas vacías y establece el servicio de sensores
    public BoardService(SensorService sensorService) {
        this.sensorService = sensorService;
        // Initialize the board with empty cells
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    //Metodo que inicializa el tablero
    @PostConstruct
    public void init() {
        placeDinosaursOnBoard();
        scheduler.scheduleAtFixedRate(this::moveDinosaurs, 0, 3, TimeUnit.SECONDS);
    }

    //Metodo que coloca los dinosaurios en el tablero
    private void placeDinosaursOnBoard() {
        List<Dinosaur> dinosaurs = sensorService.getDinosaurs();
        for (Dinosaur dinosaur : dinosaurs) {
            int x, y;
            do {
                x = random.nextInt(5);
                y = random.nextInt(5);
            } while (board[x][y].getDinosaur() != null);
            dinosaur.setX(x);
            dinosaur.setY(y);
            board[x][y].setDinosaur(dinosaur);
        }
    }

    //Metodo que mueve los dinosaurios en el tablero
    private void moveDinosaurs() {
        List<Dinosaur> dinosaurs = sensorService.getDinosaurs();
        for (Dinosaur dinosaur : dinosaurs) {
            if (dinosaur.isHunting()) {
                checkAdjacentDinosaurs(dinosaur);
            }
            int oldX = dinosaur.getX();
            int oldY = dinosaur.getY();
            int newX, newY;
            do {
                newX = oldX + random.nextInt(3) - 1;
                newY = oldY + random.nextInt(3) - 1;
            } while ((newX < 0 || newX >= 5 || newY < 0 || newY >= 5) || (board[newX][newY].getDinosaur() != null));
            board[oldX][oldY].setDinosaur(null);
            dinosaur.setX(newX);
            dinosaur.setY(newY);
            board[newX][newY].setDinosaur(dinosaur);

            // Detectar movimiento usando el sensor
            ConcreteMovementSensor sensor = new ConcreteMovementSensor(dinosaur);
            sensor.detectMovement();
        }
        logMovements(dinosaurs);
        sink.tryEmitNext(dinosaurs.stream()
                .filter(d -> board[d.getX()][d.getY()].getDinosaur() != null) // Solo dinos vivos
                .toList());
    }

    //Metodo que verifica si hay dinosaurios adyacentes en el tablero para cazar
    private void checkAdjacentDinosaurs(Dinosaur dinosaur) {
        int x = dinosaur.getX();
        int y = dinosaur.getY();

        //Bucle para recorrer las celdas adyacentes
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignorar la celda actual
                int adjX = x + i;
                int adjY = y + j;

                //Verificar si la celda adyacente está dentro del tablero
                if (adjX >= 0 && adjX < 7 && adjY >= 0 && adjY < 7) {
                    Dinosaur adjacentDinosaur = board[adjX][adjY].getDinosaur();

                    //Verificar si hay un dinosaurio adyacente y que no sea el mismo
                    if (adjacentDinosaur != null && adjacentDinosaur != dinosaur) {
                        boolean wasHunted = dinosaur.huntAttempt(dinosaur, adjacentDinosaur);
                        if (wasHunted) {
                            sensorService.removeDinosaur(adjacentDinosaur);
                            removeDinosaurFromBoard(adjacentDinosaur);
                            break; // Salir del bucle al cazar
                        }
                    }
                }
            }
        }
    }

    //Metodo que remueve un dinosaurio del tablero
    public void removeDinosaurFromBoard(Dinosaur dinosaur) {
        int x = dinosaur.getX();
        int y = dinosaur.getY();
        board[x][y].setDinosaur(null);
    }

    //Metodo que guarda los movimientos de los dinosaurios en un archivo
    private void logMovements(List<Dinosaur> dinosaurs) {
        try (FileWriter writer = new FileWriter(movementFile, false)) {
            String jsonData = objectMapper.writeValueAsString(dinosaurs);
            writer.write(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo que retorna los movimientos de los dinosaurios en el tablero
    public Flux<List<Dinosaur>> getDinosaurMovements() {
        return sink.asFlux();
    }

    //Metodo que retorna el tablero
    public Cell[][] getBoard() {
        return board;
    }

    //Clase interna que representa una celda del tablero
    public static class Cell {

        //Atributo
        private Dinosaur dinosaur;

        //Getter
        public Dinosaur getDinosaur() {
            return dinosaur;
        }

        //Setter
        public void setDinosaur(Dinosaur dinosaur) {
            this.dinosaur = dinosaur;
        }
    }
}