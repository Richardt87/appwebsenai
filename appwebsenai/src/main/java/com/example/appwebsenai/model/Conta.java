package com.example.appwebsenai.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table
public abstract class Conta {

    @Id @Column(name = "numero_conta")

    private Long numeroConta;

  // private Person pessoa;

    private Double saldo;

    public Long getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {

        this.numeroConta = numeroConta;
    }

    /*public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }*/

    public Double getSaldo() {

        return saldo;
    }

    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }
}
