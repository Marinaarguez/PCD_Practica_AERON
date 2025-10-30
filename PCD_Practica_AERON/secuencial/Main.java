package PCD_Practica_AERON.secuencial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir número de aviones
        System.out.print("Introduce el número de aviones a simular: ");
        int numAviones = scanner.nextInt();

        // Crear logger con ruta dinámica
        String logPath = "logs/secuencial/aeron-secuencial-" + System.currentTimeMillis() + ".log";
        Logger logger = new Logger(logPath);

        // Simular cada avión
        for (int i = 1; i <= numAviones; i++) {
            String id = "IBE-" + String.format("%03d", i);
            Airplane avion = new Airplane(id, logger);
            avion.iniciarCiclo();
        }

        // Cerrar el log
        logger.cerrar();
        scanner.close();
    }
}
