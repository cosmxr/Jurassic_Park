// src/main/java/com/example/jurassicpark/JurassicParkApplication.java
package com.example.jurassicpark;

import com.example.jurassicpark.service.BoardService;
import com.example.jurassicpark.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class JurassicparkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JurassicparkApplication.class, args);
    }
}