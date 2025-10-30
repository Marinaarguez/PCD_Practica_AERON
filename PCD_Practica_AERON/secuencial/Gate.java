package PCD_Practica_AERON.secuencial;

public class Gate {
    private String id;
    private boolean disponible = true;

    public Gate(String id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    public String getId() {
        return id;
    }
}
