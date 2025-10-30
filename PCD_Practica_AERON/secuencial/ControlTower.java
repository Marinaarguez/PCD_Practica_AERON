package PCD_Practica_AERON.secuencial;

public class ControlTower {
    private Logger logger;

    public ControlTower(Logger logger) {
        this.logger = logger;
    }

    public void autorizarAterrizaje(String avionId, String pistaId) {
        logger.escribirEvento("Avión [" + avionId + "] autorizado para aterrizar en Pista [" + pistaId + "]");
    }

    public void autorizarDespegue(String avionId, String pistaId) {
        logger.escribirEvento("Avión [" + avionId + "] autorizado para despegar en Pista [" + pistaId + "]");
    }
}
