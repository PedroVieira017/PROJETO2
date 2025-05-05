package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reservaquarto")
public class Reservaquarto {

    @EmbeddedId
    private ReservaquartoId id; // Usa a chave composta corretamente

    @ManyToOne
    @MapsId("reservaId") // Deve ser idêntico ao nome em ReservaquartoId
    @JoinColumn(name = "idreserva")
    private Reserva reserva;

    @ManyToOne
    @MapsId("quartoId") // Deve ser idêntico ao nome em ReservaquartoId
    @JoinColumn(name = "numero")
    private Quarto quarto;

    // Construtor vazio necessário pelo JPA
    public Reservaquarto() {}

    public Reservaquarto(Reserva reserva, Quarto quarto) {
        this.id = new ReservaquartoId(reserva.getIdreserva(), quarto.getNumero());
        this.reserva = reserva;
        this.quarto = quarto;
    }

    // Getters e Setters
    public ReservaquartoId getId() { return id; }
    public void setId(ReservaquartoId id) { this.id = id; }

    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    public Quarto getQuarto() { return quarto; }
    public void setQuarto(Quarto quarto) { this.quarto = quarto; }

    @Override
    public String toString() {
        return "Reserva: " + reserva.getIdreserva() + "\tQuarto: " + quarto.getNumero();
    }

}
