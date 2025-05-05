package com.ipvc.projeto2Final.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFatura;

    @Temporal(TemporalType.DATE)
    private Date dataemissao;

    @OneToOne
    @JoinColumn(name = "idpagamento", nullable = false)
    private Pagamento pagamento;

    public Fatura() {}

    public Fatura(Date dataemissao, Pagamento pagamento) {
        this.dataemissao = dataemissao;
        this.pagamento = pagamento;
    }

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return idFatura + "\t\"" + dataemissao + "\"\t" + pagamento.getValor(); }
    }