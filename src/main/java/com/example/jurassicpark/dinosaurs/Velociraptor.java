package com.example.jurassicpark.dinosaurs;

public class Velociraptor extends Dinosaur {
    public Velociraptor(String name, String enclosure,Boolean food) {
        super(name, enclosure, true);
    }

    @Override
    public String displayInfo() {
        return "Velociraptor: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}