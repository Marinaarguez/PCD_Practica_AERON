package PCD_Practica_AERON.secuencial;

public class Passenger {
    private String id;

    public Passenger(String id) {
        this.id = id;
    }

    public void embarcar(Logger logger) {
        logger.escribirEvento("Pasajeros se montan en Avión [" + id + "]");
    }
}
