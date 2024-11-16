package com.example.jurassicpark.dinosaurs;

//Clase que representa a un dinosaurio de la especie Velociraptor
public class Velociraptor extends Dinosaur {

    //Constructor
    public Velociraptor(String name, String enclosure,Boolean food, Boolean isHunting) {
        super(name, enclosure, true,false);
    }

    //Metodo que retorna la informacion especifica del dinosaurio
    @Override
    public String displayInfo() {
        return "Velociraptor: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}