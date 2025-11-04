package PCD_Practica_AERON.secuencial;

public class Passenger {
    private String name;
    private String flightId;

    public Passenger(String name, String flightId) {
        this.name = name;
        this.flightId = flightId;
    }

    public void checkFlight(Airplane airplane) {
        if (airplane.getId().equals(flightId) && airplane.getState() == AirplaneState.BOARDING) {
            System.out.println("  " + name + " ha embarcado en el vuelo " + flightId);
        }
    }
}
