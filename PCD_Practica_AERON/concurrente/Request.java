package concurrente;

public class Request {
    private Airplane airplane;
    private RequestType type;

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

    @Override
    public String toString() {
        return type + " de " + airplane.getName();
    }
}
