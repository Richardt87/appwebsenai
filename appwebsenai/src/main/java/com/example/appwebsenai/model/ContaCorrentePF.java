package com.example.appwebsenai.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name =  "conta")

public class ContaCorrentePF extends Conta {
    @javax.persistence.Id
    private  Long Id;

}
