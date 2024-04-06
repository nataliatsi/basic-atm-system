package models.strategies.contas;

import models.strategies.contas.Conta;

public class ContaCorrente implements Conta {
    private double saldo;
    private long numero; // Adicionando o número da conta

    public ContaCorrente(long numero) {
        this.numero = numero;
    }

    @Override
    public void depositar(double valor) {
        System.out.println("Valor antes do depósito " + saldo);
        saldo += valor;
        System.out.println("Valor após o depósito: " + saldo);
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Valor antes do saque " + saldo);
        saldo -= valor;
        System.out.println("Valor após o saque: " + saldo);
    }

    @Override
    public long getNumero(){
        return numero;
    }
}
