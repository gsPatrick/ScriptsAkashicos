package menu;
import dao.*;
import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuLogin {

    MenuVendedor menuVendedor = new MenuVendedor();

    private Scanner scanner = new Scanner(System.in);
        private ConsumidorDAO consumidorDAO;
        private VendedorDAO vendedorDAO;

        public MenuLogin(ConsumidorDAO consumidorDAO, VendedorDAO vendedorDAO) {
            this.consumidorDAO = consumidorDAO;
            this.vendedorDAO = vendedorDAO;
        }

        public void exibirMenuLogin() {


            int escolha = -1;  // Inicializa com um valor inválido para entrar no loop.

            do {
                try {

                    System.out.println("1 - Entrar como Vendedor");
                    System.out.println("2 - Entrar como Consumidor");
                    System.out.println("0 - Voltar");

                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 1:
                            fazerLoginComoVendedor();
                            break;
                        case 2:
                            fazerLoginComoConsumidor();
                            break;
                        case 0:
                            System.out.println("Saindo do Sistema de Login. Até logo!");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Porfavor digite um número valido");
                    scanner.nextLine();  // Limpa o buffer de entrada
                }

            } while (escolha != 0);

        }

    private void fazerLoginComoVendedor() {
        System.out.println("=== Login como Vendedor ===");

        for (int tentativaCPF = 0; tentativaCPF < 3; tentativaCPF++) {
            System.out.print("Digite o CPF do vendedor: ");
            String cpf = scanner.next();

            if (vendedorDAO.validarCPFVendedor(cpf)) {
                for (int tentativaSenha = 0; tentativaSenha < 3; tentativaSenha++) {
                    System.out.print("Digite a senha do vendedor: ");
                    String senha = scanner.next();

                    if (vendedorDAO.validarSenhaVendedor(cpf, senha)) {
                        System.out.println("Login bem-sucedido como vendedor!");
                        menuVendedor.menuPrincipal();
                        return;
                    } else {
                        System.out.println("Senha incorreta. Tentativas restantes: " + (2 - tentativaSenha));
                    }
                }
            } else {
                System.out.println("CPF não cadastrado como vendedor. Tentativas restantes: " + (2 - tentativaCPF));
            }
        }

        System.out.println("Limite de tentativas excedido. Falha no login como vendedor.");
    }

    private void fazerLoginComoConsumidor() {
        System.out.println("=== Login como Consumidor ===");

        for (int tentativaCPF = 0; tentativaCPF < 3; tentativaCPF++) {
            System.out.print("Digite o CPF do consumidor: ");
            String cpf = scanner.next();

            if (consumidorDAO.validarCPFConsumidor(cpf)) {
                for (int tentativaSenha = 0; tentativaSenha < 3; tentativaSenha++) {
                    System.out.print("Digite a senha do consumidor: ");
                    String senha = scanner.next();

                    if (consumidorDAO.validarSenhaConsumidor(cpf, senha)) {
                        System.out.println("Login bem-sucedido como consumidor!");
                        // Adicione sua lógica adicional para consumidores aqui.
                        return;
                    } else {
                        System.out.println("Senha incorreta. Tentativas restantes: " + (2 - tentativaSenha));
                    }
                }
            } else {
                System.out.println("CPF não cadastrado como consumidor. Tentativas restantes: " + (2 - tentativaCPF));
            }
        }

        System.out.println("Limite de tentativas excedido. Falha no login como consumidor.");
    }


    }
