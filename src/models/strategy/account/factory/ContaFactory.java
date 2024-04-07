package models.strategy.account.factory;

import models.strategy.account.Conta;
import models.strategy.account.ContaCorrente;
import models.strategy.account.ContaPoupanca;

public class ContaFactory {
    public static Conta criarConta(int tipo, long numero) {
        return switch (tipo) {
            case 1 -> new ContaPoupanca(numero);
            case 2 -> new ContaCorrente(numero);
            default -> throw new IllegalArgumentException("Tipo de conta inválida.");
        };
    }
}
