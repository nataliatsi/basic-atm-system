package models.strategy.account;

public class ContaCorrente implements Conta {
    private static final double TAXA_JUROS_TRANSFERENCIA = 0.02;
    private double saldo;
    private long numero;

    public ContaCorrente(long numero) {
        this.saldo = 0;
        this.numero = numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public long getNumero(){
        return numero;
    }

    @Override
    public void transferir( double valor) {
        double valorComTaxa = valor * (1 + TAXA_JUROS_TRANSFERENCIA);
        saldo -= valorComTaxa;
    }
}
