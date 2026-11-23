package ejercicio05;

import java.util.ArrayList;
import java.util.List;

/**
 * Sensor de humo (sujeto observable). Hay un sensor por zona y cada uno
 * mantiene su propia lista de observadores; un mismo observador puede
 * estar suscrito a varios sensores.
 */
public class SmokeSensor {

    private final String id;
    private final int floor;
    private final String zone;
    private final List<EmergencyObserver> observers = new ArrayList<>();

    public SmokeSensor(String id, int floor, String zone) {
        this.id = id;
        this.floor = floor;
        this.zone = zone;
    }

    public void subscribe(EmergencyObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void unsubscribe(EmergencyObserver observer) {
        observers.remove(observer);
    }

    /**
     * Simula la detección de humo y envía la señal de emergencia a todos los suscriptores.
     */
    public void detectSmoke() {
        System.out.println("Sensor " + id + ": se detectó humo en el piso " + floor + ", " + zone);
        SmokeAlert alert = new SmokeAlert(id, floor, zone);
        for (EmergencyObserver observer : new ArrayList<>(observers)) {
            observer.onSmokeDetected(alert);
        }
    }

    public String getId() {
        return id;
    }
}
