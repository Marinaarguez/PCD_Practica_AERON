package PCD_Practica_AERON.concurrente;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ControlTower {
    // Cola compartida de peticiones
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    // Pool de 5 operarios concurrentes
    private final ExecutorService workers = Executors.newFixedThreadPool(5);

    public ControlTower() {
        // Lanzar 5 operarios con identificador propio
        for (int i = 1; i <= 5; i++) {
            final int workerId = i;
            workers.submit(() -> {
                try {
                    while (true) {
                        Request req = queue.take(); // espera hasta que haya una petición
                        processRequest(req, workerId);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    // Método para que los aviones envíen peticiones
    public void addRequest(Request req) {
        queue.add(req);
    }

    // Lógica de procesamiento de cada petición
    private void processRequest(Request req, int workerId) {
        System.out.println("Operario " + workerId + " procesando: " + req);
        // Aquí puedes añadir la lógica de aterrizaje/despegue
        try {
            Thread.sleep(1000); // simula tiempo de trabajo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
