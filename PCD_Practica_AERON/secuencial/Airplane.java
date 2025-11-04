package PCD_Practica_AERON.secuencial;

public class Airplane {
    private String id;
    private AirplaneState state;

    public Airplane(String id) {
        this.id = id;
        this.state = AirplaneState.IN_FLIGHT;
    }

    public void setState(AirplaneState state) {
        this.state = state;
    }

    public AirplaneState getState() {
        return state;
    }

    public String getId() {
        return id;
    }
}
