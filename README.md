# Jurassic Park Project

## Objetivo del Proyecto

El objetivo de este proyecto es simular un parque jurásico donde se monitorean y gestionan dinosaurios. 
El sistema permite visualizar el movimiento de los dinosaurios en sus hábitats, monitorear sus datos vitales a través de sensores, 
y gestionar la información de los dinosaurios muertos o heridos.

## Autores

- Alberto Valera
- Marcos Ruiz
- Ines Gomez
- Mario Serrano
- Samuel Muñoz

## Estructura del Proyecto

### Controladores

- **`BoardController`**: Controlador que maneja la vista del tablero donde se muestran los dinosaurios en sus hábitats.
- **`DinosaurController`**: Controlador REST que proporciona una API para obtener la lista de dinosaurios muertos.
- **`DinosaurInfoController`**: Controlador REST que proporciona información detallada de un dinosaurio específico basado en su nombre.
- **`ImageController`**: Controlador REST que maneja la obtención de imágenes de dinosaurios.
- **`MovementSSEController`**: Controlador REST que proporciona un flujo de datos en tiempo real sobre el movimiento de los dinosaurios.
- **`SensorController`**: Controlador REST que maneja la obtención de datos de los sensores desde un archivo JSON.
- **`SensorSSEController`**: Controlador REST que proporciona un flujo de datos en tiempo real sobre los datos de los sensores.
- **`ViewController`**: Controlador que maneja las vistas principales del sistema, como la página de inicio, el monitor de sensores, y la enfermería.

### Servicios

- **`BoardService`**: Servicio que maneja la lógica del tablero, incluyendo la colocación y movimiento de los dinosaurios.
- **`SensorService`**: Servicio que maneja la lógica de los sensores, incluyendo la generación de dinosaurios y la monitorización de sus datos.

### Dinosaurios

- **`Dinosaur`**: Clase abstracta que representa un dinosaurio y contiene atributos y métodos comunes a todos los dinosaurios.
- **`Stegosaurus`**: Clase que extiende `Dinosaur` y representa un Stegosaurus.
- **`T_Rex`**: Clase que extiende `Dinosaur` y representa un T-Rex.
- **`Triceratops`**: Clase que extiende `Dinosaur` y representa un Triceratops.
- **`Velociraptor`**: Clase que extiende `Dinosaur` y representa un Velociraptor.

### Sensores

- **`Sensor`**: Interfaz que define el método `readData` para todos los sensores.
- **`HeartRateSensor`**: Interfaz que extiende `Sensor` y define el método `monitorHeartRate`.
- **`HungerSensor`**: Interfaz que extiende `Sensor` y define el método `measureHunger`.
- **`MovementSensor`**: Interfaz que extiende `Sensor` y define el método `detectMovement`.
- **`TemperatureSensor`**: Interfaz que extiende `Sensor` y define el método `measureTemperature`.
- **`ConcreteHeartRateSensor`**: Implementación concreta de `HeartRateSensor`.
- **`ConcreteHungerSensor`**: Implementación concreta de `HungerSensor`.
- **`ConcreteMovementSensor`**: Implementación concreta de `MovementSensor`.
- **`ConcreteTemperatureSensor`**: Implementación concreta de `TemperatureSensor`.

### Fábricas

- **`SensorFactory`**: Interfaz que define métodos para crear diferentes tipos de sensores.
- **`ConcreteSensorFactory`**: Implementación concreta de `SensorFactory` que crea instancias de sensores concretos.

### Otros

- **`Scheduler`**: Clase que maneja la programación de tareas periódicas.
- **`JurassicparkApplication`**: Clase principal que inicia la aplicación Spring Boot.

## Vistas

- **`board.html`**: Página que muestra el tablero con los dinosaurios en sus hábitats.
- **`dinosaurios.html`**: Página que muestra el tablero con los dinosaurios y permite moverlos.
- **`enfermeria.html`**: Página que muestra la lista de dinosaurios muertos o heridos.
- **`home.html`**: Página de inicio del proyecto.
- **`monitor.html`**: Página que muestra los datos de los sensores en tiempo real.

## Recursos

- **Imágenes**: Las imágenes de los dinosaurios se encuentran en la carpeta `src/main/resources/images`.

## Link al repositorio: https://github.com/cosmxr/Jurassic_Park.git
