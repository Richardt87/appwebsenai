package com.example.appwebsenai.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public abstract class Conta {

    private Long numeroConta;

    private Person pessoa;


    private Double saldo;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
