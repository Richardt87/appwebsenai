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

    @Column(name = "type")
    private AccountType accountType;

    @Transient
    private String error;


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Person getPerson() {
        return person();
    }

    private Person person() {
        return null;
    }


    public void setPerson(Person person) {
    }
}
