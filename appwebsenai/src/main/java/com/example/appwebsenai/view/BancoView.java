package com.example.appwebsenai.view;


import com.example.appwebsenai.controller.BancoController;
import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BancoView {

    @Autowired
    private BancoController bancoController;

    @GetMapping("/consultaSaldo")
    public Double consultaSaldo(){
        Conta conta = new ContaCorrentePF();
        conta.setSaldo(100D);
        return bancoController.consultaSaldo(conta);

    }
}
