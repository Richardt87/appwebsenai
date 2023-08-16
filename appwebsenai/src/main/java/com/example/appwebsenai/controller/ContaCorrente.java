package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;

public interface ContaCorrente {



    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    void transferir(Double quantidade, Conta conta);

    Double consultaSaldo();


    Double consultaSaldo(Conta conta);
}
