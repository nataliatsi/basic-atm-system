package models.strategy.database;

import models.Cliente;

import java.util.Scanner;

public interface Database {
    void cadastrarCliente(Scanner scanner);
    void fazerLogin(Scanner scanner);
    void consultarSaldo(Cliente cliente);
    void fazerTransferencia(Cliente cliente, Scanner scanner);
    void receberValor(Cliente cliente, Scanner scanner);

}
