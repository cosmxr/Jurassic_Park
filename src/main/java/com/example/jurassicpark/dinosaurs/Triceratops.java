package com.example.jurassicpark.dinosaurs;

//Clase que representa a un dinosaurio de la especie Triceratops
public class Triceratops extends Dinosaur {

    //Constructor
    public Triceratops(String name, String enclosure, Boolean food,Boolean isHunting) {
        super(name, enclosure, false,false);
    }

    //Metodo que retorna la informacion especifica del dinosaurio
    @Override
    public String displayInfo() {
        return "Triceratops: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}