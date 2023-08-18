package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BancoController implements ContaCorrente {

    @Autowired
    private BancoRepository bancoRepository;
    @Autowired
    private Controller controller;
    private Long number = 0L;
    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public  Conta criarConta(String name){
        ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
        number++;
        contaCorrentePF.setNumeroConta(number);
        bancoRepository.save(contaCorrentePF);
        return contaCorrentePF;
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
