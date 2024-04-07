package models.strategy.account;

public interface Conta {
    void depositar(double valor);
    void transferir(double valor);
    long getNumero();
    double getSaldo();

}
