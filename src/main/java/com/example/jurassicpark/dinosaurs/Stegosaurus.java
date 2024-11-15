package com.example.jurassicpark.dinosaurs;

public class Stegosaurus extends Dinosaur {
    public Stegosaurus(String name, String enclosure, Boolean food, Boolean isHunting) {
        super(name, enclosure, false,false,false);
    }

    @Override
    public String displayInfo() {
        return "Stegosaurus: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}