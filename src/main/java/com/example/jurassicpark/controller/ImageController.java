package com.example.jurassicpark.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//Clase que controla la vista de las imágenes de los dinosaurios
@RestController
public class ImageController {

    //Metodo que muestra la vista de las imágenes de los dinosaurios
    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {

            //Se obtiene la imagen
            Resource image = new ClassPathResource("images/" + imageName);
            //Se verifica si la imagen existe y es legible para mostrarla
            if (image.exists() && image.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");
                return new ResponseEntity<>(image, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

    }
}