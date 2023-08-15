package com.example.appwebsenai.model;

public interface ContaCorrente {



    Double sacar(Double quantidade);

    void depositar(Double quantidade);

    void transferir(Double quantidade);

    Double consultaSaldo();




}
