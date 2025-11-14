package PCD_Practica_AERON.concurrente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ControlTower {
    private final ExecutorService executor;

    public ControlTower() {
        // Crea un pool fijo de 3 hilos para procesar solicitudes
        this.executor = Executors.newFixedThreadPool(3);
    }

    public void addRequest(Request request) {
        executor.submit(() -> processRequest(request));
    }

    private void processRequest(Request request) {
        System.out.println("Processing " + request.getType() + " for " + request.getAirplane());
        try {
            Thread.sleep(1000); // Simula tiempo de operación
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed " + request.getType() + " for " + request.getAirplane());
    }

    public void shutdown() {
        executor.shutdown();
    }
}
