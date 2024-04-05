package models.strategies.contas.factory;

import models.strategies.contas.Conta;
import models.strategies.contas.ContaCorrente;
import models.strategies.contas.ContaPoupanca;

public class ContaFactory {
    public static Conta criarConta(int tipo, long numero) {
        switch (tipo){
            case 1:
                System.out.println("Conta poupança criada com sucesso!");
                System.out.println("Número da conta: " + numero);
                return new ContaPoupanca();
            case  2:
                System.out.println("Conta corrente criada com sucesso!");
                System.out.println("Número da conta: " + numero);
                return new ContaCorrente();
            default:
                throw new IllegalArgumentException("Tipo de conta inválida.");
        }
    }
}
