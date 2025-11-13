package PCD_Practica_AERON.concurrente;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        Airplane a1 = new Airplane("AERO01");
        Airplane a2 = new Airplane("AERO02");
        Airplane a3 = new Airplane("AERO03");
        Airplane a4 = new Airplane("AERO04");
        Airplane a5 = new Airplane("AERO05");

        tower.addRequest(new Request(a1, RequestType.LANDING));
        tower.addRequest(new Request(a2, RequestType.TAKEOFF));
        tower.addRequest(new Request(a3, RequestType.LANDING));
        tower.addRequest(new Request(a4, RequestType.TAKEOFF));
        tower.addRequest(new Request(a5, RequestType.LANDING));
    }
}
