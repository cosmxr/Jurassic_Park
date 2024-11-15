package com.example.jurassicpark.dinosaurs;

public class Triceratops extends Dinosaur {
    public Triceratops(String name, String enclosure, Boolean food,Boolean isHunting) {
        super(name, enclosure, false,false,false);
    }

    @Override
    public String displayInfo() {
        return "Triceratops: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}