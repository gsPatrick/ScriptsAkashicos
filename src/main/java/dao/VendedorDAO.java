package dao;
import model.*;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendedorDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/loja";
    private static final String USER = "postgres";
    private static final String PASSWORD = "projetonnnutri";

    private static final String INSERIR_VENDEDOR = "INSERT INTO vendedor (email, senha, nome, cpf) VALUES (?, ?, ?, ?)";

    public void cadastrarVendedor(Vendedor vendedor) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_VENDEDOR)) {

            preparedStatement.setString(1, vendedor.getEmail());
            preparedStatement.setString(2, vendedor.getSenha());
            preparedStatement.setString(3, vendedor.getNome());
            preparedStatement.setString(4, vendedor.getCpf());

            preparedStatement.executeUpdate();
            System.out.println("Vendedor cadastrado com sucesso!");

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                // Código 23505 é específico do PostgreSQL para violação de restrição UNIQUE
                System.out.println("Email ou CPF já existem na base de dados. Não foi possível cadastrar o vendedor.");
            } else {
                e.printStackTrace(); // Trate a exceção de maneira apropriada para sua aplicação
            }
        }
    }

    private static final String buscar_vendedor_por_cpf = "SELECT * FROM vendedor WHERE cpf = ?"; // Busca o CPF na tabela vendedor
    private static final String validar_senha_vendedor = "SELECT * FROM vendedor WHERE cpf = ? AND senha = ?";


    public boolean validarCPFVendedor(String cpf) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(buscar_vendedor_por_cpf)) {

            preparedStatement.setString(1, cpf);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Se houver resultados, o CPF é válido
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção de maneira apropriada para sua aplicação
            return false;
        }
    }

    public boolean validarSenhaVendedor(String cpf, String senha) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(validar_senha_vendedor)) {

            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Se houver resultados, a senha é válida
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção de maneira apropriada para sua aplicação
            return false;
        }
    }


}
