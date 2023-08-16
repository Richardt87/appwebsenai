package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import org.springframework.stereotype.Service;


@Service
public class BancoController implements ContaCorrente {


    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);

    }

    @Override
    public void transferir(Double quantidade, Conta conta) {

    }

    @Override
    public Double consultaSaldo() {
        return null;
    }

    @Override
    public Double consultaSaldo(Conta conta) {
        return conta.getSaldo();
    }
}
