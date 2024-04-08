package models.strategy.database;

import models.Cliente;
import models.strategy.account.Conta;
import models.strategy.account.factory.ContaFactory;

import java.util.*;

public class BancoDeDados implements Database{
    private final Map<String, Cliente> clientes = new HashMap<>();
    private final Random random = new Random();

    private long gerarNumeroAleatorio() {
        return Math.abs(random.nextLong() % 10000000000L);
    }
    private Conta criarConta(int tipoConta) {
        long numeroDaConta = gerarNumeroAleatorio();
        return ContaFactory.criarConta(tipoConta, numeroDaConta);
    }

    public void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (clientes.containsKey(username)) {
            System.out.println("Nome de usuário já existe. Escolha outro.");
        } else {
            System.out.print("Digite o tipo de conta (1 para poupança, 2 para corrente): ");
            int tipoConta = scanner.nextInt();

            Conta conta = criarConta(tipoConta);
            Cliente cliente = new Cliente(username, senha);
            cliente.adicionarConta(conta);
            clientes.put(username, cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    public void fazerLogin(Scanner scanner) {
        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = clientes.get(username);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido!");
            menuConta(cliente, scanner);
        } else {
            System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
        }
    }

    public void consultarSaldo(Cliente cliente) {
        List<Conta> contas = cliente.getContas();
        if (contas.isEmpty()) {
            System.out.println("Você não possui contas associadas.");
            return;
        }
        System.out.println("Saldo das contas:");
        for (Conta conta : contas) {
            System.out.println("Número da Conta: " + conta.getNumero());
            System.out.println("Saldo: " + conta.getSaldo());
        }
    }

    private Conta selecionarConta(List<Conta> contas, Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Você não possui contas associadas.");
            return null;
        }

        System.out.println("Selecione a conta:");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + " - Número da Conta: " + contas.get(i).getNumero());
        }
        int opcaoConta = scanner.nextInt();
        scanner.nextLine();

        return contas.get(opcaoConta - 1);
    }

    public void fazerTransferencia(Cliente cliente, Scanner scanner) {
        List<Conta> contas = cliente.getContas();
        Conta contaOrigem = selecionarConta(contas, scanner);

        if (contaOrigem == null) {
            return;
        }

        System.out.println("Digite o valor da transferência:");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        if (contaOrigem.getSaldo() >= valorTransferencia) {
            contaOrigem.transferir(valorTransferencia);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void receberValor(Cliente cliente, Scanner scanner) {
        List<Conta> contas = cliente.getContas();
        Conta contaDestino = selecionarConta(contas, scanner);

        if (contaDestino == null) {
            return;
        }

        System.out.println("Digite o valor a ser recebido:");
        double valorRecebido = scanner.nextDouble();
        scanner.nextLine();

        contaDestino.depositar(valorRecebido);
        System.out.println("Valor recebido com sucesso.");
    }

    public void menuConta(Cliente cliente, Scanner scanner) {
        while (true) {
            System.out.println("\nMenu da Conta:");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Receber valor");
            System.out.println("4 - Transferir");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo da sua conta...");
                    return;
                case 1:
                    System.out.print("Digite o tipo de conta (1 para poupança, 2 para corrente): ");
                    int tipoConta = scanner.nextInt();
                    Conta novaConta = criarConta(tipoConta);
                    cliente.adicionarConta(novaConta);
                    System.out.println("Nova conta criada com sucesso.");
                    break;
                case 2:
                    consultarSaldo(cliente);
                    break;
                case 3:
                    receberValor(cliente, scanner);
                    break;
                case 4:
                    fazerTransferencia(cliente, scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
