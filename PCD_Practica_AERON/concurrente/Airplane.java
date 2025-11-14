package PCD_Practica_AERON.concurrente;

public class Airplane {
    private final String id;

    public Airplane(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Airplane " + id;
    }
}
