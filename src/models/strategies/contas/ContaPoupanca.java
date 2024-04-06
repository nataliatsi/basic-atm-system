package models.strategies.contas;

public class ContaPoupanca implements Conta {
    private double saldo;
    private long numero;

    public ContaPoupanca(long numero) {
        this.saldo = 0;
        this.numero = numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
    public long getNumero() {
        return numero;
    }
}
