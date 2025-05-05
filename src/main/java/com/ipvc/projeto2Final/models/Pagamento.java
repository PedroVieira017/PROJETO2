package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpagamento;

    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String metodopagamento;

    @ManyToOne
    @JoinColumn(name = "idreserva", nullable = false)
    private Reserva reserva;

    public Pagamento() {}

    public Pagamento(BigDecimal valor, Date data, String metodopagamento, Reserva reserva) {
        this.valor = valor;
        this.data = data;
        this.metodopagamento = metodopagamento;
        this.reserva = reserva;
    }

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMetodopagamento() {
        return metodopagamento;
    }

    public void setMetodopagamento(String metodopagamento) {
        this.metodopagamento = metodopagamento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-12s %-20s Reserva: %-3s",
                idpagamento,
                valor + "€",
                data,
                "\"" + metodopagamento + "\"",
                reserva.getIdreserva());
    }
}