package menu;
import dao.*;
import model.*;

import java.util.Scanner;

public class LoginVendedor {

    private VendedorDAO vendedorDAO;
    private Vendedor vendedor;
    private MenuVendedor menuVendedor;
    private Scanner scanner;

    public LoginVendedor() {
        vendedorDAO = new VendedorDAO();
        vendedor = new Vendedor();
        menuVendedor = new MenuVendedor();
        scanner = new Scanner(System.in);
    }


    public void executarLoginVendedor(){

        System.out.println("=== Login como Vendedor ===");

        for (int tentativaCPF = 0; tentativaCPF < 3; tentativaCPF++) {
            System.out.print("Digite o CPF do vendedor: ");
            String cpf = scanner.next();



            if (vendedorDAO.validarCPFVendedor(cpf)) {
                vendedor.setusuarioLogadoCPF(cpf);

                for (int tentativaSenha = 0; tentativaSenha < 3; tentativaSenha++) {
                    System.out.print("Digite a senha do vendedor: ");
                    String senha = scanner.next();

                    if (vendedorDAO.validarSenhaVendedor(cpf, senha)) {


                        System.out.println("Login feio com sucesso");


                        vendedor.setUsuarioLogadoId(vendedorDAO.obterIdPorCPF(cpf));
                        vendedor.setUsuarioLogadoNome(vendedorDAO.obterNomePorCPF(cpf));
                        vendedor.setusuarioLogadoCPF(cpf);



                        menuVendedor.menuPrincipalVendedor(vendedor);

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
}
