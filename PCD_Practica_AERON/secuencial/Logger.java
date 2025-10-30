package PCD_Practica_AERON.secuencial;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private PrintWriter writer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructor que recibe la ruta del archivo de log
    public Logger(String path) {
        try {
            // Asegura que la carpeta exista
            File archivo = new File(path);
            archivo.getParentFile().mkdirs();
            System.out.println("Archivo de log creado en: " + archivo.getAbsolutePath());

            // Inicializa el escritor
            writer = new PrintWriter(new FileWriter(archivo, true));
            escribirEvento("Iniciando simulación en modo: sequential");
        } catch (IOException e) {
            System.out.println("Error al crear el log: " + e.getMessage());
            writer = null;
        }
    }

    // Método para escribir eventos en el log
    public void escribirEvento(String mensaje) {
        if (writer != null) {
            String timestamp = "[" + LocalDateTime.now().format(formatter) + "] ";
            writer.println(timestamp + mensaje);
            writer.flush();
            System.out.println(timestamp + mensaje); // También lo muestra en consola
        } else {
            System.out.println("Logger no inicializado. No se puede escribir: " + mensaje);
        }
    }

    // Método para cerrar el archivo de log
    public void cerrar() {
        if (writer != null) {
            escribirEvento("Cerrando registro");
            writer.close();
        }
    }
}
