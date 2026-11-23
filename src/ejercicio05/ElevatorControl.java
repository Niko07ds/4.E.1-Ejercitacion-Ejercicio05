package ejercicio05;

/**
 * Nuevo dispositivo de respuesta agregado después del diseño original.
 * Para incorporarlo no hizo falta modificar ninguna clase de los sensores.
 */
public class ElevatorControl implements EmergencyObserver {

    @Override
    public void onSmokeDetected(SmokeAlert alert) {
        System.out.println("Control de ascensores: se bloquean y se envían a planta baja por la alerta del piso " + alert.floor());
    }
}
