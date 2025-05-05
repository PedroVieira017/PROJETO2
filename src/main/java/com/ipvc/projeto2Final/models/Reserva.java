package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreserva;

    @Temporal(TemporalType.DATE)
    private Date datacheckin;

    @Temporal(TemporalType.DATE)
    private Date datacheckout;

    private String status;
    private BigDecimal precototal;

    @ManyToOne
    @JoinColumn(name = "idhospede", nullable = false)
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Gerente gerente;

    public Reserva() {}

    public Reserva(Date datacheckIn, Date datacheckout, String status, BigDecimal precoTotal, Hospede hospede, Gerente gerente) {
        this.datacheckin = datacheckin;
        this.datacheckout = datacheckout;
        this.status = status;
        this.precototal = precototal;
        this.hospede = hospede;
        this.gerente = gerente;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getDatacheckin() {
        return datacheckin;
    }

    public void setDatacheckin(Date datacheckin) {
        this.datacheckin = datacheckin;
    }

    public Date getDatacheckout() {
        return datacheckout;
    }

    public void setDatacheckout(Date datacheckout) {
        this.datacheckout = datacheckout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrecototal() {
        return precototal;
    }

    public void setPrecototal(BigDecimal precototal) {
        this.precototal = precototal;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return idreserva + "\t" + datacheckin + " → " + datacheckout +
                "\t" + status +
                "\t" + precototal + "€" +
                "\tHóspede: " + hospede.getIdhospede() +
                "\tGerente: " + gerente.getIdgerente();
    }

}