package ejercicio05;

/**
 * Interfaz común de todos los sistemas de respuesta ante emergencias.
 * Agregar un nuevo dispositivo solo requiere implementar esta interfaz.
 */
public interface EmergencyObserver {

    void onSmokeDetected(SmokeAlert alert);
}
