import java.util.*;

import models.Cliente;
import models.strategy.account.Conta;
import models.strategy.account.factory.ContaFactory;

public class Main {
    private static final Map<String, Cliente> clientes = new HashMap<>();
    private static final Random random = new Random();

    public static void main(String[] args) {

        inicializarBancoDeDados();
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
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    fazerLogin(scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void inicializarBancoDeDados() {
        Cliente cliente1 = new Cliente("user1", "senha123");
        cliente1.adicionarConta(ContaFactory.criarConta(1, gerarNumeroAleatorio()));
        clientes.put("user1", cliente1);

        Cliente cliente2 = new Cliente("user2", "senha456");
        cliente2.adicionarConta(ContaFactory.criarConta(2,gerarNumeroAleatorio()));
        clientes.put("user2", cliente2);

        Cliente cliente3 = new Cliente("user3", "senha789");
        cliente3.adicionarConta(ContaFactory.criarConta(1, gerarNumeroAleatorio()));
        cliente3.adicionarConta(ContaFactory.criarConta(2,gerarNumeroAleatorio()));
        clientes.put("user3", cliente3);
    }

    private static Conta criarConta(int tipoConta) {
        long numeroDaConta = gerarNumeroAleatorio();
        return ContaFactory.criarConta(tipoConta, numeroDaConta);
    }

    private static void cadastrarCliente(Scanner scanner) {
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

    private static void fazerLogin(Scanner scanner) {
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

    private static long gerarNumeroAleatorio() {
        return Math.abs(random.nextLong() % 10000000000L);
    }

    private static void menuConta(Cliente cliente, Scanner scanner) {
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

    private static void consultarSaldo(Cliente cliente) {
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

    private static void fazerTransferencia(Cliente cliente, Scanner scanner) {
        List<Conta> contas = cliente.getContas();
        if (contas.isEmpty()) {
            System.out.println("Você não possui contas associadas.");
            return;
        }

        System.out.println("Selecione a conta de origem:");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + " - Número da Conta: " + contas.get(i).getNumero());
        }
        int opcaoContaOrigem = scanner.nextInt();
        scanner.nextLine();

        Conta contaOrigem = contas.get(opcaoContaOrigem - 1);

        System.out.println("Digite o valor da transferência:");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        if (contaOrigem.getSaldo() >= valorTransferencia) {
            contaOrigem.transferir(valorTransferencia);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }


    private static void receberValor(Cliente cliente, Scanner scanner) {
        List<Conta> contas = cliente.getContas();
        if (contas.isEmpty()) {
            System.out.println("Você não possui contas associadas.");
            return;
        }

        System.out.println("Selecione a conta em que deseja receber o valor:");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + " - Número da Conta: " + contas.get(i).getNumero());
        }
        int opcaoConta = scanner.nextInt();
        scanner.nextLine();

        Conta contaDestino = contas.get(opcaoConta - 1);

        System.out.println("Digite o valor a ser recebido:");
        double valorRecebido = scanner.nextDouble();
        scanner.nextLine();

        contaDestino.depositar(valorRecebido);
        System.out.println("Valor recebido com sucesso.");
    }

}
