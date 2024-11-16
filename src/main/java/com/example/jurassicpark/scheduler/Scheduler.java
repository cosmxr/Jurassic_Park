package com.example.jurassicpark.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Clase que representa un planificador de tareas
public class Scheduler {

    //Variable que representa el planificador de tareas
    private final ScheduledExecutorService scheduler;

    //Constructor
    public Scheduler(int poolSize) {
        this.scheduler = Executors.newScheduledThreadPool(poolSize);
    }

    //Metodo que programa una tarea para ser ejecutada una sola vez
    public void scheduleAtFixedRate(Runnable task, long initialDelay, long period, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(task, initialDelay, period, unit);
    }

    //Metodo para detener el planificador de tareas
    public void shutdown() {
        scheduler.shutdown();
    }
}