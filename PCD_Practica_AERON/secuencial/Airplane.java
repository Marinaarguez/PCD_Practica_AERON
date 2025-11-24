package PCD_Practica_AERON.secuencial;

public class Airplane {
    private final String id;
    private AirplaneState state;

    public Airplane(String id) {
        this.id = id;
        this.state = AirplaneState.IN_AIR;
    }

    public String getId() {
        return id;
    }

    public AirplaneState getState() {
        return state;
    }

    public void setState(AirplaneState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Avión " + id;
    }
}
