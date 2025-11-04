package PCD_Practica_AERON.secuencial;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTower {
    private Queue<Airplane> landingQueue = new LinkedList<>();
    private Queue<Airplane> takeOffQueue = new LinkedList<>();
    private FlightPanel panel;
    private Logger logger;

    public ControlTower(FlightPanel panel, Logger logger) {
        this.panel = panel;
        this.logger = logger;
    }

    public void receiveLandingRequest(Airplane airplane) {
        landingQueue.add(airplane);
        airplane.setState(AirplaneState.LANDING_ASSIGNED);
        panel.update(airplane);
        logger.log("Solicitud de aterrizaje recibida de " + airplane.getId());
    }

    public void processNextLanding() {
        if (!landingQueue.isEmpty()) {
            Airplane airplane = landingQueue.poll();
            airplane.setState(AirplaneState.LANDING);
            panel.update(airplane);
            logger.log("Avión " + airplane.getId() + " ha aterrizado.");
        }
    }

    public void receiveTakeOffRequest(Airplane airplane) {
        takeOffQueue.add(airplane);
        airplane.setState(AirplaneState.TAKING_OFF_REQUESTED);
        panel.update(airplane);
        logger.log("Solicitud de despegue recibida de " + airplane.getId());
    }

    public void processNextTakeOff() {
        if (!takeOffQueue.isEmpty()) {
            Airplane airplane = takeOffQueue.poll();
            airplane.setState(AirplaneState.DEPARTING);
            panel.update(airplane);
            logger.log("Avión " + airplane.getId() + " ha despegado.");
        }
    }
}
