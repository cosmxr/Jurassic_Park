package com.example.jurassicpark.dinosaurs;

//Clase que representa a un dinosaurio de la especie Stegosaurus
public class Stegosaurus extends Dinosaur {

    //Constructor
    public Stegosaurus(String name, String enclosure, Boolean food, Boolean isHunting) {
        super(name, enclosure, false,false);
    }

    //Metodo que retorna la informacion especifica del dinosaurio
    @Override
    public String displayInfo() {
        return "Stegosaurus: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}