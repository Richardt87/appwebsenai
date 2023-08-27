package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.AccountType;
import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import com.example.appwebsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.Optional;


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
    public void delete(String name){
        bancoRepository.delete(this.consultaConta(name));
    }

    public  ContaCorrentePF criarConta(String name, String accounttype) throws Exception{
        ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
        StringBuilder message = new StringBuilder();
        if (accounttype == null){
            message.append("\nNecessario informar tipo da conta!");
            }

        switch (accounttype){
            case "POUPANCA" :
                contaCorrentePF.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE" :
                contaCorrentePF.setAccountType(AccountType.CONTA_CORRENTE);
            default:
                message.append("tipo da conta não é suportado");
        }

        Person person = controller.findPerson(name);
        if (person != null && contaCorrentePF.getError() == null){
            number++;
            contaCorrentePF.setNumeroConta(number);
            contaCorrentePF.setPerson(person);
            bancoRepository.save(contaCorrentePF);
        }else if (contaCorrentePF.getError() == null){
            message.append("pessoa ");
            message.append(name).append(" informada não foi cadastrada");
        }
        if (!message.isEmpty()){
            contaCorrentePF.setError(message.toString());
        }
        return contaCorrentePF;
    }

    public ContaCorrentePF consultaConta(String name){

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for (ContaCorrentePF cc : contas){
            if (cc.getPerson() != null && cc.getPerson().getName().equals("name")){
                return cc;
            }
        }
        return null;
    }

    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);

    }

    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        ContaCorrentePF destino = bancoRepository.findById(contaDestino).get();
        ContaCorrentePF origem = bancoRepository.findById(contaOrigem).get();

        if (origem.getSaldo() >= valor){
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = "A conta do(a) " + destino.getPerson().getName() + " recebeu a transferencia no valor de R$: " + valor;
        }else{
            message = message + " Saldo insuficiente para a operação";
        }
        return message;

    }
    @Override
    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo;
    }

    @Override
    public Double consultaSaldo(Conta conta) {
        return null;
    }

}
