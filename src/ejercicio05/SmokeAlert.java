package ejercicio05;

/**
 * Señal de emergencia con la ubicación exacta del sensor que detectó humo.
 */
public record SmokeAlert(String sensorId, int floor, String zone) {

    public String location() {
        return "piso " + floor + ", " + zone + " (sensor " + sensorId + ")";
    }
}
