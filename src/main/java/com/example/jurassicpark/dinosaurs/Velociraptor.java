package com.example.jurassicpark.dinosaurs;

public class Velociraptor extends Dinosaur {

    public Velociraptor(String name, String enclosure,Boolean food, Boolean isHunting) {
        super(name, enclosure, true,false,false);
    }

    @Override
    public String displayInfo() {
        return "Velociraptor: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}