package com.example.jurassicpark.dinosaurs;

import lombok.Getter;
import lombok.Setter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

//Clase abstracta que representa a los dinosaurios
public abstract class Dinosaur {

    //Atributos
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

    //Constructor
    public Dinosaur(String name, String enclosure, boolean isCarnivorous, boolean isHunting) {
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

    //Metodo que retorna si el dinosaurio se está moviendo
    public Boolean isMoving() {
        return isMoving;
    }

    //Metodo que actualiza los atributos del dinosaurio de forma aleatoria
    public void updateAttributes() {
        this.temperature = generateRandomTemperature();
        this.heartRate = generateRandomHeartRate();
        this.isMoving = generateRandomMovement();
        decreaseHungerLevel();
        if (isCarnivorous && hungerLevel == 0) {
            isHunting();
        }
    }

    //Metodo que disminuye el nivel de hambre del dinosaurio
    private void decreaseHungerLevel() {
        double decrease = 1.0 + (30.0 - 1.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        decrease = Double.parseDouble(df.format(decrease));
        this.hungerLevel = Math.max(0, this.hungerLevel - decrease);
    }

    //Metodo que retorna si el dinosaurio está cazando
    public boolean isHunting() {
        if (hungerLevel == 0 && isCarnivorous()){
            System.out.println(name + " is hunting!");
            return true;}
        else{
            return false;
        }
    }

    //Metodo que intenta cazar a otro dinosaurio
    public boolean huntAttempt(Dinosaur hunter, Dinosaur prey) {
        if (hunter.isCarnivorous() && prey != null) {
            double successChance = random.nextDouble(); // Probabilidad de éxito
            if (successChance > 0.5) { // 50% de probabilidad de éxito
                prey.setHunting(false); // Detener su caza
                hunter.setHungerLevel(100);

                return true; // Presa cazada
            }
        }
        return false; // Presa escapó
    }

    //Metodo que genera una temperatura aleatoria
    private double generateRandomTemperature() {
        double temperature = 30.0 + (40.0 - 30.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(temperature));
    }

    //Metodo que genera un ritmo cardiaco aleatorio
    private int generateRandomHeartRate() {
        return 60 + random.nextInt(41);
    }

    //Metodo que genera un movimiento aleatorio
    private boolean generateRandomMovement() {
        return random.nextDouble() < 0.5;
    }

    //Metodo que genera una fecha de nacimiento aleatoria para el dinosaurio
    private String generateRandomBirthDate() {
        long minDay = new Date(90, 0, 1).getTime();
        long maxDay = new Date(120, 0, 1).getTime();
        long randomDay = minDay + (long) (random.nextDouble() * (maxDay - minDay));
        Date birthDate = new Date(randomDay);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(birthDate);
    }

    //Metodo que genera una altura aleatoria para el dinosaurio
    private double generateRandomHeight() {
        double height =  2.0 + (10.0 - 2.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(height));
    }

    //Metodo que genera un peso aleatorio para el dinosaurio
    private double generateRandomWeight() {
        double weight = 500.0 + (10000.0 - 500.0) * random.nextDouble();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(weight));
    }

    //Metodo que muestra la información del dinosaurio
    public String displayInfo() {
        return "  Fecha de Nacimiento: " + birthDate + "\n\n" +
                "Estatura: " + height + " metros\n\n" +
                "Peso: " + weight + " kg\n\n" +
                "Carnívoro: " + (isCarnivorous ? "Sí" : "No");
    }
}