package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipo;
    private Boolean administrador;
    private Boolean equipalimpeza;
    private Boolean rececionista;

    public Tipo() {}

    public Tipo(Boolean administrador, Boolean equipalimpeza, Boolean rececionista) {
        this.administrador = administrador;
        this.equipalimpeza = equipalimpeza;
        this.rececionista = rececionista;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Boolean getEquipaLimpeza() {
        return equipalimpeza;
    }

    public void setEquipaLimpeza(Boolean equipaLimpeza) {
        this.equipalimpeza = equipaLimpeza;
    }

    public Boolean getRececionista() {
        return rececionista;
    }

    public void setRececionista(Boolean rececionista) {
        this.rececionista = rececionista;
    }

    @Override
    public String toString() {
        return String.format(
                "%-6s Admin: %-6s Limpeza: %-8s Rececionista: %-6s",
                idtipo,
                administrador,
                equipalimpeza,
                rececionista
        );
    }
}