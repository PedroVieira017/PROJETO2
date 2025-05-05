package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "promocao")
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromocao;

    @Temporal(TemporalType.DATE)
    private Date periodovalidade;

    private BigDecimal desconto;

    @ManyToOne
    @JoinColumn(name = "numero", nullable = false)
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "idreserva", nullable = false)
    private Reserva reserva;

    public Promocao() {}

    public Promocao(Date periodovalidade, BigDecimal desconto, Quarto quarto, Reserva reserva) {
        this.periodovalidade = periodovalidade;
        this.desconto = desconto;
        this.quarto = quarto;
        this.reserva = reserva;
    }

    public Integer getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(Integer idPromocao) {
        this.idPromocao = idPromocao;
    }

    public Date getPeriodovalidade() {
        return periodovalidade;
    }

    public void setPeriodovalidade(Date periodovalidade) {
        this.periodovalidade = periodovalidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return String.format(
                "%-5s %-12s %-8s Quarto: %-5s Reserva: %-3s",
                idPromocao,
                periodovalidade,
                desconto.multiply(BigDecimal.valueOf(100)) + "%",
                quarto.getNumero(),
                reserva.getIdreserva()
        );
    }
}