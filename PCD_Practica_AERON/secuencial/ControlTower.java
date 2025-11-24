package PCD_Practica_AERON.secuencial;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTower {
    private final Queue<Airplane> landingQueue;
    private final Queue<Airplane> takeOffQueue;
    private final Queue<String> runways;
    private final Queue<String> gates;
    private final FlightPanel panel;
    private final Logger logger;

    public ControlTower(FlightPanel panel, Logger logger) {
        this.panel = panel;
        this.logger = logger;
        this.landingQueue = new LinkedList<>();
        this.takeOffQueue = new LinkedList<>();
        this.runways = new LinkedList<>();
        this.gates = new LinkedList<>();

        for (int i = 1; i <= 2; i++)
            runways.add("Pista-" + i);
        for (int i = 1; i <= 2; i++)
            gates.add("Puerta-" + i);
    }

    public void receiveLandingRequest(Airplane airplane) {
        landingQueue.add(airplane);
        logger.log("Petición de aterrizaje recibida para " + airplane.getId());
    }

    public void processNextLanding() {
        if (landingQueue.isEmpty())
            return;

        Airplane airplane = landingQueue.poll();
        if (!runways.isEmpty() && !gates.isEmpty()) {
            String runway = runways.poll();
            String gate = gates.poll();

            System.out.println("Asignando pista y puerta a " + airplane.getId());
            logger.log("Aterrizando " + airplane.getId() + " en " + runway + ", asignado a " + gate);
            airplane.setState(AirplaneState.AT_GATE);
            panel.update(airplane);

            runways.add(runway);
        } else {
            System.out.println("No hay recursos disponibles para el aterrizaje de " + airplane.getId());
            logger.log("No hay recursos disponibles para el aterrizaje de " + airplane.getId());
        }
    }

    public void receiveTakeOffRequest(Airplane airplane) {
        takeOffQueue.add(airplane);
        logger.log("Petición de despegue recibida para " + airplane.getId());
    }

    public void processNextTakeOff() {
        if (takeOffQueue.isEmpty())
            return;

        Airplane airplane = takeOffQueue.poll();
        if (!runways.isEmpty()) {
            String runway = runways.poll();

            System.out.println("Avión " + airplane.getId() + " despegando desde " + runway);
            logger.log("Despegue de " + airplane.getId() + " desde " + runway);
            airplane.setState(AirplaneState.IN_AIR);
            panel.update(airplane);

            runways.add(runway);
            gates.add("Puerta-" + (gates.size() + 1));
        } else {
            System.out.println("No hay pista disponible para el despegue de " + airplane.getId());
            logger.log("No hay pista disponible para el despegue de " + airplane.getId());
        }
    }
}
