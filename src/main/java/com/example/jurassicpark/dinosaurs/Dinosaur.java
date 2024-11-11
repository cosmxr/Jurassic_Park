package com.example.jurassicpark.dinosaurs;

import lombok.Getter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public abstract class Dinosaur {
    @Getter
    private String name;
    @Getter
    private String enclosure;
    @Getter
    private double temperature;
    @Getter
    private int heartRate;
    private boolean isMoving;
    @Getter
    private String birthDate;
    @Getter
    private double height;
    @Getter
    private double weight;
    @Getter
    private boolean isCarnivorous;
    private Random random = new Random();

    public Dinosaur(String name, String enclosure, boolean isCarnivorous) {
        this.name = name;
        this.enclosure = enclosure;
        this.temperature = generateRandomTemperature();
        this.heartRate = generateRandomHeartRate();
        this.isMoving = generateRandomMovement();
        this.birthDate = generateRandomBirthDate();
        this.height = generateRandomHeight();
        this.weight = generateRandomWeight();
        this.isCarnivorous = isCarnivorous;
    }

    public Boolean isMoving() {
        return isMoving;
        }

    public void updateAttributes() {
        this.temperature = generateRandomTemperature();
        this.heartRate = generateRandomHeartRate();
        this.isMoving = generateRandomMovement();
    }

    private double generateRandomTemperature() {
        double temperature = 30.0 + (40.0 - 30.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(temperature));
    }

    private int generateRandomHeartRate() {
        return 60 + random.nextInt(41);
    }

    private boolean generateRandomMovement() {
        return random.nextDouble() < 0.5;
    }

    private String generateRandomBirthDate() {
        long minDay = new Date(90, 0, 1).getTime();
        long maxDay = new Date(120, 0, 1).getTime();
        long randomDay = minDay + (long) (random.nextDouble() * (maxDay - minDay));
        Date birthDate = new Date(randomDay);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(birthDate);
    }

    private double generateRandomHeight() {
        double height =  2.0 + (10.0 - 2.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(height));
    }

    private double generateRandomWeight() {
        double weight = 500.0 + (10000.0 - 500.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(weight));
    }

    public String displayInfo() {
        return "  Fecha de Nacimiento: " + birthDate + "\n\n" +
                "Estatura: " + height + " metros\n\n" +
                "Peso: " + weight + " kg\n\n" +
                "Carnívoro: " + (isCarnivorous ? "Sí" : "No");
    }
}