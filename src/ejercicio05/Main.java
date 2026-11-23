package ejercicio05;

public class Main {

    public static void main(String[] args) {
        SmokeSensor kitchenSensor = new SmokeSensor("S-01", 1, "cocina");
        SmokeSensor serverRoomSensor = new SmokeSensor("S-02", 3, "sala de servidores");
        SmokeSensor hallwaySensor = new SmokeSensor("S-03", 5, "pasillo norte");

        EmergencyObserver alarmCenter = new AlarmCenter();
        EmergencyObserver concierge = new ConciergeService();
        EmergencyObserver sprinklersFloor1 = new SprinklerSystem(1);
        EmergencyObserver sprinklersFloor3 = new SprinklerSystem(3);

        System.out.println("Vinculando los sistemas de respuesta con los sensores");
        // La central y la conserjería escuchan varias fuentes de peligro
        subscribeToAll(alarmCenter, kitchenSensor, serverRoomSensor, hallwaySensor);
        subscribeToAll(concierge, kitchenSensor, serverRoomSensor, hallwaySensor);
        // Los rociadores escuchan solo los sensores de su zona
        kitchenSensor.subscribe(sprinklersFloor1);
        serverRoomSensor.subscribe(sprinklersFloor3);

        System.out.println();
        System.out.println("Simulación 1: humo en la cocina");
        kitchenSensor.detectSmoke();

        System.out.println();
        System.out.println("Simulación 2: humo en la sala de servidores");
        serverRoomSensor.detectSmoke();

        System.out.println();
        System.out.println("Se incorpora el control de ascensores sin modificar los sensores");
        EmergencyObserver elevatorControl = new ElevatorControl();
        subscribeToAll(elevatorControl, serverRoomSensor, hallwaySensor);

        System.out.println();
        System.out.println("Simulación 3: humo en el pasillo norte");
        hallwaySensor.detectSmoke();

        System.out.println();
        System.out.println("Simulación 4: nuevamente humo en la sala de servidores");
        serverRoomSensor.detectSmoke();
    }

    private static void subscribeToAll(EmergencyObserver observer, SmokeSensor... sensors) {
        for (SmokeSensor sensor : sensors) {
            sensor.subscribe(observer);
        }
    }
}
