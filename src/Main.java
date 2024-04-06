import java.util.*;

import models.Cliente;
import models.strategies.contas.Conta;
import models.strategies.contas.factory.ContaFactory;

public class Main {
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Random random = new Random();

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


    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (clientes.containsKey(username)) {
            System.out.println("Nome de usuário já existe. Escolha outro.");
        } else {
            long numeroDaConta = gerarNumeroAleatorio();
            System.out.print("Digite o tipo de conta (1 para poupança, 2 para corrente): ");
            int tipoConta = scanner.nextInt();

            Conta conta = ContaFactory.criarConta(tipoConta, numeroDaConta);
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
            menuConta(cliente,scanner);
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
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Receber valor");
            System.out.println("3 - Transferir");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo da sua conta...");
                    return;
                case 1:
                    consultarSaldo(cliente);
                    break;
                case 2:
                    System.out.println("Recebimento de valor ainda não implementado.");
                    break;
                case 3:
                    System.out.println("Transferência ainda não implementada.");
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

}
