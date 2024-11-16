package com.example.jurassicpark.dinosaurs;

//Clase que representa a un dinosaurio de la especie T-Rex
public class T_Rex extends Dinosaur {

    //Constructor
    public T_Rex(String name, String enclosure,Boolean food, Boolean isHunting) {
        super(name, enclosure, true,false);
    }

    //Metodo que retorna la informacion especifica del dinosaurio
    @Override
    public String displayInfo() {
        return "T-Rex: " + getName() + " recinto: " + getEnclosure() + "\n" + super.displayInfo();
    }
}