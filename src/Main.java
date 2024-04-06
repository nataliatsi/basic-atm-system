import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import models.Cliente;
import models.strategies.contas.Conta;
import models.strategies.contas.factory.ContaFactory;

public class Main {
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        inicializarBancoDeDados();
        Scanner scanner = new Scanner(System.in);

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


    private static void inicializarBancoDeDados() {
        clientes.put("user1", new Cliente("user1", "senha123"));
        clientes.put("user2", new Cliente("user2", "senha456"));
        clientes.put("user3", new Cliente("user3", "senha789"));
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
        } else {
            System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
        }
    }

    private static long gerarNumeroAleatorio() {
        return Math.abs(random.nextLong() % 10000000000L);
    }
}
