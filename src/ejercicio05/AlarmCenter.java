package ejercicio05;

/**
 * Central de alarmas: reacciona ante cualquier sensor al que esté suscrita.
 */
public class AlarmCenter implements EmergencyObserver {

    @Override
    public void onSmokeDetected(SmokeAlert alert) {
        System.out.println("Central de alarmas: se activa la sirena y se avisa a los bomberos. Ubicación: " + alert.location());
    }
}
