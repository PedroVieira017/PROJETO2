package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quartogerente")
public class Quartogerente {

    @EmbeddedId
    private QuartogerenteId id;

    @ManyToOne
    @JoinColumn(name = "numero", insertable = false, updatable = false)
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "idreserva", insertable = false, updatable = false)
    private Reserva reserva;

    @Temporal(TemporalType.DATE)
    private Date dataatribuicao;

    private String status;

    public Quartogerente() {}

    public Quartogerente(QuartogerenteId id, Date dataatribuicao, String status) {
        this.id = id;
        this.dataatribuicao = dataatribuicao;
        this.status = status;
    }

    public QuartogerenteId getId() {
        return id;
    }

    public void setId(QuartogerenteId id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Date getDataatribuicao() {
        return dataatribuicao;
    }

    public void setDataatribuicao(Date dataatribuicao) {
        this.dataatribuicao = dataatribuicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quarto: " + quarto.getNumero() +
                "\tReserva: " + reserva.getIdreserva() +
                "\tData: " + dataatribuicao +
                "\tStatus: " + status;
    }

}
