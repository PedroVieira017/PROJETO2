package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;

@Entity
@Table(name = "gerente")
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgerente;
    private String nome;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    private Tipo tipo;

    public Gerente() {}

    public Gerente(String nome, String email, String password, Tipo tipo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }

    public Integer getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Integer idgerente) {
        this.idgerente = idgerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-30s %-15s Tipo: %-3s",
                idgerente,
                "\"" + nome + "\"",
                "\"" + email + "\"",
                "\"" + password + "\"",
                tipo.getIdtipo());
    }

}