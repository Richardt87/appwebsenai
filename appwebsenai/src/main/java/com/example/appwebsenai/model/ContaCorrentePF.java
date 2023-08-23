package com.example.appwebsenai.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;


@Entity
@Table(name =  "conta")
public class ContaCorrentePF extends Conta {

    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;


    private Double saldo;

    @OneToOne
    private Person person;

    public Person getPerson() {
        return person();
    }

    private Person person() {
        return null;
    }


    public void setPerson(Person person) {
    }
}
