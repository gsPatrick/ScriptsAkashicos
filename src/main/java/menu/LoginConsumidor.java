package menu;
import dao.*;
import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class LoginConsumidor {

    // Instancia objetos
    ConsumidorDAO consumidorDAO = new ConsumidorDAO();
    Consumidor consumidor = new Consumidor();
    Scanner scanner = new Scanner(System.in);
    //

    public void executarLoginConsumidor() {

        System.out.println("=== Login como Consumidor ===");

        for (int tentativaCPF = 0; tentativaCPF < 3; tentativaCPF++) {
            System.out.print("Digite o CPF do consumidor: ");
            String cpf = scanner.next();

            if (consumidorDAO.validarCPFConsumidor(cpf)) {
                for (int tentativaSenha = 0; tentativaSenha < 3; tentativaSenha++) {
                    System.out.print("Digite a senha do consumidor: ");
                    String senha = scanner.next();

                    if (consumidorDAO.validarSenhaConsumidor(cpf, senha)) {

                        consumidor.setUsuarioLogadoIdConsumidor(consumidorDAO.obterIdPorCPF(cpf));
                        consumidor.setusuarioLogadoNomeConsumidor(consumidorDAO.obterNomePorCPF(cpf));
                        System.out.println("Login bem-sucedido");
                        int usuarioLogadoId = consumidor.getUsuarioLogadoIdConsumidor();
                        String usuarioLogadoNomeConsumidor = consumidor.getusuarioLogadoNomeConsumidor();
                        System.out.println("ID do usuário logado: " + usuarioLogadoId);
                        System.out.println("Seu nome é: " + usuarioLogadoNomeConsumidor);

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