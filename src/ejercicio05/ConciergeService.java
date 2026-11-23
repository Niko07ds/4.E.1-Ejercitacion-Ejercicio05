package ejercicio05;

/**
 * Servicio de conserjería: avisa al personal y coordina la evacuación.
 */
public class ConciergeService implements EmergencyObserver {

    @Override
    public void onSmokeDetected(SmokeAlert alert) {
        System.out.println("Conserjería: se inicia la evacuación y se envía personal a " + alert.location());
    }
}
