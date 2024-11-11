package com.example.jurassicpark.dinosaurs;

public class Stegosaurus extends Dinosaur {
    public Stegosaurus(String name, String enclosure, Boolean food) {
        super(name, enclosure, false);
    }

    @Override
    public String displayInfo() {
        return "Stegosaurus: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}