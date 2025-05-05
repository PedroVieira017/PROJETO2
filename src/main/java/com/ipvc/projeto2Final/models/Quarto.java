package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Quarto {

    @Id
    private Integer numero;

    private BigDecimal preco;

    private String status; // <-- adicionamos isto!

    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    private Tipo tipo;

    // Getters e Setters
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return String.format(
                "%-6s %-10s %-15s %-8s",
                numero,
                "\"" + tipo.getIdtipo() + "\"",
                "\"" + status + "\"",
                preco
        );
    }
}
