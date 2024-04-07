import java.util.*;

import models.Cliente;
import models.strategy.database.BancoDeDados;

public class Main {
    private static final BancoDeDados bancoDeDados = new BancoDeDados();

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
                    bancoDeDados.cadastrarCliente(scanner);
                    break;
                case 2:
                    bancoDeDados.fazerLogin(scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}


