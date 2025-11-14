package PCD_Practica_AERON.concurrente;

public class Request {
    private final Airplane airplane;
    private final RequestType type;

    public Request(Airplane airplane, RequestType type) {
        this.airplane = airplane;
        this.type = type;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public RequestType getType() {
        return type;
    }
}
