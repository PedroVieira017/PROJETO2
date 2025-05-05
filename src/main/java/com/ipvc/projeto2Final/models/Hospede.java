package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhospede;
    private String nome;
    private String email;
    private String telefone;
    private String password;

    public Hospede() {}

    public Hospede(String nome, String email, String telefone, String password) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
    }

    public Integer getIdhospede() {
        return idhospede;
    }

    public void setIdhospede(Integer idhospede) {
        this.idhospede = idhospede;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-30s %-15s %-12s",
                idhospede,
                "\"" + nome + "\"",
                "\"" + email + "\"",
                "\"" + telefone + "\"",
                "\"" + password + "\"");
    }
}
