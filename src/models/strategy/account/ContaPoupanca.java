package models.strategy.account;

public class ContaPoupanca implements Conta {
    private static final double TAXA_JUROS_TRANSFERENCIA = 0.05;
    private static final int LIMITE_TRANSFERENCIA_DIARIA = 3;
    private double saldo;
    private long numero;
    private int transferenciasHoje;

    public ContaPoupanca(long numero) {
        this.saldo = 0;
        this.numero = numero;
        this.transferenciasHoje = 0;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    @Override
    public long getNumero() {
        return numero;
    }

    public int getTransferenciasHoje() {
        return transferenciasHoje;
    }

    public boolean podeTransferir(double valor) {
        if (getTransferenciasHoje() >= LIMITE_TRANSFERENCIA_DIARIA) {
            System.out.println("Limite de transferências diárias excedido.");
            return false;
        }

        double valorComTaxa = valor * (1 + TAXA_JUROS_TRANSFERENCIA);
        return saldo >= valorComTaxa;
    }

    @Override
    public void transferir(double valor) {
        if (podeTransferir(valor)) {
            double valorComTaxa = valor * (1 + TAXA_JUROS_TRANSFERENCIA);
            saldo -= valorComTaxa;
            transferenciasHoje++;
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Transferência não realizada.");
        }
    }


}
