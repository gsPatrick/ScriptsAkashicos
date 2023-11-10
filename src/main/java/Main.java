import dao.*;
import model.*;
import menu.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection conexao = Conexao.getConecction();
        ContaDAO contaDAO = new ContaDAO(conexao);
        Conta conta = new Conta();

        // Crie uma instância de MenuCadastro, passando o ContaDAO como parâmetro
        MenuCadastro menuCadastro = new MenuCadastro(contaDAO);

        menuCadastro.cadastrarConta();



    }
}
