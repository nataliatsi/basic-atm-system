import models.Cliente;
import models.strategies.contas.Conta;
import models.strategies.contas.factory.ContaFactory;
import models.strategies.transfers.Transfer;
import models.strategies.transfers.factory.TransferenciaFactory;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    return;
                case 1:
                    System.out.println("Cadastro:");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    Random random = new Random();
                    long numeroConta = Math.abs(random.nextLong() % 10000000000L);

                    System.out.println("---------------------------------------------------------");
                    System.out.print("Digite o tipo de conta (1 para poupança, 2 para corrente): ");
                    int tipoConta = scanner.nextInt();

                    Conta conta = ContaFactory.criarConta(tipoConta, numeroConta);

                    Cliente cliente = new Cliente(nome, cpf, endereco, telefone, numeroConta);
                    cliente.adicionarConta(conta);
                    String cl = cliente.toString();
                    System.out.println(cl);

                    System.out.println("Conta cadastrada com sucesso!");
                    System.out.println("Número da conta: " + numeroConta);
                    break;
                case 2:
                    // TODO
                    System.out.println("Funcionalidade de login não implementada ainda.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        /*
        System.out.println("Escolha o tipo de transferência:");
        System.out.println("1 - PIX");
        System.out.println("2 - TED");
        System.out.println("3 - TEF");
        int tipoTransferencia = scanner.nextInt();

        Transfer estrategia = TransferenciaFactory.criarTransferencia(tipoTransferencia);

        System.out.print("Digite o valor da transferência: R$");
        double valorTransferencia = scanner.nextDouble();

        estrategia.transferir(valorTransferencia);

        scanner.close();

         */
        /*
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Entrar na conta");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    return;
                case 1:
                    System.out.print("Digite o tipo de conta (1 para poupança, 2 para corrente): ");
                    int tipo = scanner.nextInt();
                    Random random = new Random();
                    long numero = Math.abs(random.nextLong() % 10000000000L);

                    Conta conta = ContaFactory.criarConta(tipo, numero);
                    break;

                case 2:
                    // Implemente a funcionalidade de entrar na conta
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            scanner.close();
        }

         */

    }
}

