package dao;
import model.*;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsumidorDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/loja";
    private static final String USER = "postgres";
    private static final String PASSWORD = "projetonnnutri";

    private static final String INSERIR_CONSUMIDOR = "INSERT INTO consumidor (email, senha, nome, cpf) VALUES (?, ?, ?, ?)";

    public void cadastrarConsumidor(Consumidor consumidor) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_CONSUMIDOR)) {

            preparedStatement.setString(1, consumidor.getEmail());
            preparedStatement.setString(2, consumidor.getSenha());
            preparedStatement.setString(3, consumidor.getNome());
            preparedStatement.setString(4, consumidor.getCpf());

            preparedStatement.executeUpdate();
            System.out.println("Consumidor cadastrado com sucesso!");

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                // Código 23505 é específico do PostgreSQL para violação de restrição UNIQUE
                System.out.println("Email ou CPF já existem na base de dados. Não foi possível cadastrar o consumidor.");
            } else {
                e.printStackTrace(); // Trate a exceção de maneira apropriada para sua aplicação
            }
        }
    }

    private static final String buscar_consumidor_por_cpf = "SELECT * FROM consumidor WHERE cpf = ?";
    private static final String validar_senha_consumidor = "SELECT * FROM consumidor WHERE cpf = ? AND senha = ?";

    public boolean validarCPFConsumidor(String cpf) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(buscar_consumidor_por_cpf))

             {

            preparedStatement.setString(1, cpf);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Se houver resultados, o CPF é válido
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção de maneira apropriada para sua aplicação
            return false;
        }
    }

    public boolean validarSenhaConsumidor(String cpf, String senha) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(validar_senha_consumidor)) {

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