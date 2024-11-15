package com.example.jurassicpark.dinosaurs;

public class T_Rex extends Dinosaur {
    public T_Rex(String name, String enclosure,Boolean food, Boolean isHunting) {
        super(name, enclosure, true,false,false);
    }

    @Override
    public String displayInfo() {
        return "T-Rex: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}