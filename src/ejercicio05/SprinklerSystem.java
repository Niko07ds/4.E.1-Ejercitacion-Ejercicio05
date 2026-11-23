package ejercicio05;

/**
 * Sistema de rociadores de un piso. Solo se activa cuando la alerta
 * corresponde a la zona que protege.
 */
public class SprinklerSystem implements EmergencyObserver {

    private final int coveredFloor;

    public SprinklerSystem(int coveredFloor) {
        this.coveredFloor = coveredFloor;
    }

    @Override
    public void onSmokeDetected(SmokeAlert alert) {
        if (alert.floor() == coveredFloor) {
            System.out.println("Rociadores del piso " + coveredFloor + ": se activan en " + alert.zone());
        } else {
            System.out.println("Rociadores del piso " + coveredFloor + ": la alerta es de otro piso, no se activan");
        }
    }
}
