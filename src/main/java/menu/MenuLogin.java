package menu;
import dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuLogin {

    // Criar instâncias das classes necessárias
    private LoginVendedor loginVendedor = new LoginVendedor();
    private LoginConsumidor loginConsumidor = new LoginConsumidor();


            //

    public void exibirMenuLogin() {

        Scanner scanner = new Scanner(System.in);


        int escolha = -1;  // Inicializa com um valor inválido para entrar no loop.

        do {
            try {

                System.out.println("1 - Entrar como Vendedor");
                System.out.println("2 - Entrar como Consumidor");
                System.out.println("0 - Voltar");

                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        loginVendedor.executarLoginVendedor();
                        break;
                    case 2:
                        loginConsumidor.executarLoginConsumidor();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Porfavor digite um número valido");
            }

        } while (escolha != 0);
    }
}



