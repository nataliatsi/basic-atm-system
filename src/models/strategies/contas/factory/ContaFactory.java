package models.strategies.contas.factory;

import models.strategies.contas.Conta;
import models.strategies.contas.ContaCorrente;
import models.strategies.contas.ContaPoupanca;

public class ContaFactory {
    public static Conta criarConta(int tipo, long numero) {
        return switch (tipo) {
            case 1 -> new ContaPoupanca(numero);
            case 2 -> new ContaCorrente(numero);
            default -> throw new IllegalArgumentException("Tipo de conta inválida.");
        };
    }
}
