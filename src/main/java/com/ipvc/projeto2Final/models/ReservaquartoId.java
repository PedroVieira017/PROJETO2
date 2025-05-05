package com.ipvc.projeto2Final.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ReservaquartoId {
    private Integer reservaId; // O nome precisa corresponder ao MapsId na outra classe
    private Integer quartoId;  // O nome precisa corresponder ao MapsId na outra classe

    // Construtor vazio obrigatório pelo JPA
    public ReservaquartoId() {}

    public ReservaquartoId(Integer reservaId, Integer quartoId) {
        this.reservaId = reservaId;
        this.quartoId = quartoId;
    }

    // Getters e Setters
    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }

    public Integer getQuartoId() { return quartoId; }
    public void setQuartoId(Integer quartoId) { this.quartoId = quartoId; }
}
