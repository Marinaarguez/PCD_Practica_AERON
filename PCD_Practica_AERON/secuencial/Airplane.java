package PCD_Practica_AERON.secuencial;

public class Airplane {
    private String id;
    private Logger logger;
    private long startTime;

    public Airplane(String id, Logger logger) {
        this.id = id;
        this.logger = logger;
    }

    public void iniciarCiclo() {
        startTime = System.currentTimeMillis();
        logger.escribirEvento("Avión [" + id + "] INICIA ciclo");
        logger.escribirEvento("Avión [" + id + "] solicita aterrizaje");
        logger.escribirEvento("Avión [" + id + "] autorizado para aterrizar en Pista [R1]");
        logger.escribirEvento("Avión [" + id + "] aterrizó en Pista [R1]");
        logger.escribirEvento("Avión [" + id + "] se desplaza a Puerta [PUE1]");
        logger.escribirEvento("Pasajeros se montan en Avión [" + id + "]");
        logger.escribirEvento("Avión [" + id + "] finalizó en Puerta [PUE1]");
        logger.escribirEvento("Avión [" + id + "] solicita despegue");
        logger.escribirEvento("Avión [" + id + "] autorizado para despegar en Pista [R1]");
        logger.escribirEvento("Avión [" + id + "] despegó de Pista [R1]");
        logger.escribirEvento("Avión [" + id + "] ahora está en vuelo");
        long duration = System.currentTimeMillis() - startTime;
        logger.escribirEvento("Avión [" + id + "] COMPLETÓ ciclo en " + duration + " ms");
    }
}
