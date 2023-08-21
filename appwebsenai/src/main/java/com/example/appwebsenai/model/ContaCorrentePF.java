package com.example.appwebsenai.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name =  "conta")
public class ContaCorrentePF extends Conta {

    @Id
    @Column(name = "numero_conta")
    @Override
    public Double getSaldo() {
        return super.getSaldo();
    }

}
