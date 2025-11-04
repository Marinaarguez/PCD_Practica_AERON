package PCD_Practica_AERON.secuencial;

public class FlightPanel {
    public void update(Airplane airplane) {
        System.out.println("Panel: Avión " + airplane.getId() + " : " + airplane.getState());
    }
}
