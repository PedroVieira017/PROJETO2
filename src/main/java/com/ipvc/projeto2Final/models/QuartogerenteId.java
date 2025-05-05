// QuartogerenteId.java
package com.ipvc.projeto2Final.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuartogerenteId implements Serializable {
    private Integer numero;
    private Integer idreserva;

    public QuartogerenteId() {}

    public QuartogerenteId(Integer numero, Integer idreserva) {
        this.numero = numero;
        this.idreserva = idreserva;
    }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public Integer getIdreserva() { return idreserva; }
    public void setIdreserva(Integer idreserva) { this.idreserva = idreserva; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuartogerenteId that = (QuartogerenteId) o;
        return Objects.equals(numero, that.numero) && Objects.equals(idreserva, that.idreserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, idreserva);
    }
}