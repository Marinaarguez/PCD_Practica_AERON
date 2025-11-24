package PCD_Practica_AERON.secuencial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("¿Cuántos aviones quieres simular? ");
            n = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Iniciando simulación de tráfico aéreo...");
        System.out.println("Se procesarán " + n + " aviones de forma secuencial.");

        Logger logger = new Logger("logs/aeron.log");
        FlightPanel panel = new FlightPanel();
        ControlTower tower = new ControlTower(panel, logger);

        List<Airplane> airplanes = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String id = "AER" + String.format("%03d", i);
            Airplane airplane = new Airplane(id);
            airplanes.add(airplane);

            Passenger passenger = new Passenger("Pasajero " + i, id);
            passengers.add(passenger);

            tower.receiveLandingRequest(airplane);
        }

        for (Airplane airplane : airplanes) {
            System.out.println("Procesando aterrizaje para " + airplane.getId());
            tower.processNextLanding();

            System.out.println("Pasajeros embarcando en " + airplane.getId());
            airplane.setState(AirplaneState.BOARDING);
            panel.update(airplane);
            logger.log("Avión " + airplane.getId() + " en embarque.");

            for (Passenger p : passengers) {
                p.checkFlight(airplane);
            }

            System.out.println("Preparando despegue para " + airplane.getId());
            tower.receiveTakeOffRequest(airplane);
            tower.processNextTakeOff();
        }

        System.out.println("Todos los aviones han sido procesados.");
        System.out.println("Fin de la simulación de tráfico aéreo.");
    }
}
