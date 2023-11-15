import dao.*;
import model.*;
import menu.*;

import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsumidorDAO consumidorDAO = new ConsumidorDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        AdicionarCursoDAO adicionarCursoDAO = new AdicionarCursoDAO();

        // Criar instâncias necessárias
        MenuVendedor menuVendedor = new MenuVendedor(adicionarCursoDAO, vendedorDAO, null);
        MenuLogin menuLogin = new MenuLogin(consumidorDAO, vendedorDAO, menuVendedor);
        MenuCadastro menuCadastro = new MenuCadastro(menuLogin);





        System.out.println("Seja bem-vindo ao Scripts Akáshicos");

        int opcao;
        do {
            exibirMenuEscolha();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    menuLogin.exibirMenuLogin(); //
                    break;
                case 2:
                    menuCadastro.exibirMenuCadastro();
                    break;
                case 0:
                    System.out.println("Saindo do Scripts Akáshicos !");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

    private static void exibirMenuEscolha() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Fazer cadastro");
        System.out.println("0 - Sair");
    }
}
