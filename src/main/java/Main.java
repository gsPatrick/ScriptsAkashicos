import dao.*;
import model.*;
import menu.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuCadastro menuCadastro = new MenuCadastro();
        MenuLogin menuLogin = new MenuLogin(); // Supondo que você tenha uma classe MenuLogin

        System.out.println("Seja bem-vindo ao Scripts Akáshicos");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    menuCadastro.exibirMenuCadastro();
                    break;
                case 2:
                   // menuLogin.exibirMenuLogin(); // Chame o método que lida com a lógica de login
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Adeus!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Fazer cadastro");
        System.out.println("2 - Fazer Login");
        System.out.println("0 - Sair");
    }
}