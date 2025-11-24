package PCD_Practica_AERON.secuencial;

public class Passenger {
    private String name;
    private String flightId;

    public Passenger(String name, String flightId) {
        this.name = name;
        this.flightId = flightId;
    }

    public void checkFlight(Airplane airplane) {
        if (airplane.getId().equals(flightId)) {
            switch (airplane.getState()) {
                case BOARDING -> System.out.println("  " + name + " ha embarcado en el vuelo " + flightId);
                case AT_GATE -> System.out.println("  " + name + " espera en la puerta para el vuelo " + flightId);
                case ON_RUNWAY -> System.out.println("  " + name + " ve el avión " + flightId + " en la pista");
                case IN_AIR -> System.out.println("  " + name + " sabe que el avión " + flightId + " está en el aire");
                default -> System.out.println("  " + name + " no tiene información sobre el vuelo " + flightId);
            }
        }
    }
}
