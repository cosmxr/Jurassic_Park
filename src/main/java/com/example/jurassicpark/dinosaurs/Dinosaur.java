// Dinosaur.java
package com.example.jurassicpark.dinosaurs;

import com.example.jurassicpark.service.BoardService;
import com.example.jurassicpark.service.SensorService;
import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private double temperature;
    @Getter @Setter
    private int heartRate;
    @Setter
    private boolean isMoving;
    @Getter
    private String birthDate;
    @Getter
    private double height;
    @Getter
    private double weight;
    @Getter @Setter
    private double hungerLevel;
    @Getter @Setter
    private int x;
    @Getter @Setter
    private int y;
    @Getter
    private boolean isCarnivorous;
    private Random random = new Random();
    @Getter @Setter
    public boolean isHunting;
    @Setter
    public boolean isHunted;

    public Dinosaur(String name, String enclosure, boolean isCarnivorous, boolean isHunting, boolean isHunted) {
        this.name = name;
        this.enclosure = enclosure;
        this.temperature = generateRandomTemperature();
        this.heartRate = generateRandomHeartRate();
        this.isMoving = generateRandomMovement();
        this.birthDate = generateRandomBirthDate();
        this.height = generateRandomHeight();
        this.weight = generateRandomWeight();
        this.isCarnivorous = isCarnivorous;
        this.hungerLevel = 100.0;
        this.x = random.nextInt(6);
        this.y = random.nextInt(6);
    }

    public Boolean isMoving() {
        return isMoving;
    }
public boolean isHunted(Dinosaur dinosaur){
        return isHunted;
}
    public void updateAttributes() {
        this.temperature = generateRandomTemperature();
        this.heartRate = generateRandomHeartRate();
        this.isMoving = generateRandomMovement();
        decreaseHungerLevel();
        if (isCarnivorous && hungerLevel == 0) {
            isHunting();
        }
    }

    private void decreaseHungerLevel() {
        double decrease = 1.0 + (30.0 - 1.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        decrease = Double.parseDouble(df.format(decrease));
        this.hungerLevel = Math.max(0, this.hungerLevel - decrease);
    }

    public boolean isHunting() {
        if (hungerLevel == 0 && isCarnivorous()){
            System.out.println(name + " is hunting!");
            return true;}
        else{
            return false;
        }
    }
    public void huntAttempt(Dinosaur hunter, Dinosaur prey) {
        if (!hunter.isCarnivorous() || prey == null) {
            System.out.println(hunter.getName() + " cannot hunt " + prey.getName());
            return;
        }

        Random random = new Random();
        boolean success = random.nextBoolean(); // Simulate if the hunt is successful or not

        if (success) {
            System.out.println(hunter.getName() + " successfully hunted " + prey.getName() + "!");
            hunter.setHungerLevel(100.0);
            prey.setHeartRate(0);
            isHunted(prey);
        } else {
            System.out.println(hunter.getName() + " failed to hunt " + prey.getName());
        }
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