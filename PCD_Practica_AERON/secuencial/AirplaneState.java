package PCD_Practica_AERON.secuencial;

public enum AirplaneState {
    IN_FLIGHT, // En vuelo
    LANDING_ASSIGNED, // Aterrizaje asignado
    LANDING, // Aterrizando
    BOARDING, // Embarcando
    TAKING_OFF_REQUESTED, // Despegue solicitado
    DEPARTING, // Despegando
    IN_AIR, // En el aire
    ON_RUNWAY, // En pista
    AT_GATE;// En puerta

}
