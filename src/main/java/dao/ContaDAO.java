package dao;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import model.*;

public class ContaDAO {
    private Connection conexao;  // A conexão com o banco de dados
    public ContaDAO(Connection conexao) {
        this.conexao = conexao;
    }  // Construtor que recebe a conexão como parâmetro

    public boolean emailExistente(String email) {
        String sql = "SELECT COUNT(*) FROM conta WHERE email = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            // Trate a exceção conforme necessário (registre, lance outra exceção, etc.)
            e.printStackTrace();
            return false;
        }
    }

    public boolean cpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM conta WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            // Trate a exceção conforme necessário (registre, lance outra exceção, etc.)
            e.printStackTrace();
            return false;
        }
    }
    public void cadastrarConta(Conta conta, String tipoConta) {
        String sqlConta = "INSERT INTO conta (email, nome, cpf, senha, tipo_conta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmtConta = conexao.prepareStatement(sqlConta, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmtConta.setString(1, conta.getEmail());
            stmtConta.setString(2, conta.getNome());
            stmtConta.setString(3, conta.getCpf());
            stmtConta.setString(4, conta.getSenha());
            stmtConta.setString(5, tipoConta);

            int rowsAffected = stmtConta.executeUpdate();

            if (rowsAffected > 0) {
                int idConta = obterIdGerado(stmtConta);
                conta.setIdConta(idConta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cadastrarConsumidor(int idConta, int idContaConsumidor, String nomeConsumidor, String cpfConsumidor, String emailConsumidor, String senhaConsumidor) {
        String sqlConsumidor = "INSERT INTO consumidor (id_conta_base, id_conta_consumidor, nome, cpf, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
        cadastrarUsuarioConsumidor(idConta, idContaConsumidor, sqlConsumidor, nomeConsumidor, cpfConsumidor, emailConsumidor, senhaConsumidor);
    }

    private void cadastrarVendedor(int idConta, int idContaVendedor, String nomeVendedor, String cpfVendedor, String emailVendedor, String senhaVendedor) {
        String sqlVendedor = "INSERT INTO vendedor (id_conta_base, id_conta_vendedor, nome, cpf, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
        cadastrarUsuarioVendedor(idConta, idContaVendedor, sqlVendedor, nomeVendedor, cpfVendedor, emailVendedor, senhaVendedor);
    }


    public void cadastrarUsuarioVendedor(int idConta, int idContaVendedor, String sql, String nomeVendedor, String cpfVendedor, String emailVendedor, String senhaVendedor) {
        try (PreparedStatement stmtVendedor = conexao.prepareStatement(sql)) {
            stmtVendedor.setInt(1, idConta);
            stmtVendedor.setInt(2, idContaVendedor);
            stmtVendedor.setString(3, nomeVendedor);
            stmtVendedor.setString(4, cpfVendedor);
            stmtVendedor.setString(5, emailVendedor);
            stmtVendedor.setString(6, senhaVendedor);

            stmtVendedor.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarUsuarioConsumidor(int idConta, int idContaConsumidor, String sql, String nomeConsumidor, String cpfConsumidor, String emailConsumidor, String senhaConsumidor) {
        try (PreparedStatement stmtConsumidor = conexao.prepareStatement(sql)) {
            stmtConsumidor.setInt(1, idConta);
            stmtConsumidor.setInt(2, idContaConsumidor);
            stmtConsumidor.setString(3, nomeConsumidor);
            stmtConsumidor.setString(4, cpfConsumidor);
            stmtConsumidor.setString(5, emailConsumidor);
            stmtConsumidor.setString(6, senhaConsumidor);

            stmtConsumidor.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int obterIdGerado(PreparedStatement stmt) throws SQLException {
        try (var resultSet = stmt.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new NoSuchElementException("Nenhuma chave gerada encontrada.");
            }
        }
    }

    private void fecharRecurso(AutoCloseable recurso) {
        try {
            if (recurso != null) {
                recurso.close();
            }
        } catch (Exception e) {
            e.printStackTrace(); // ou outro tratamento de erro, se necessário
        }
    }
}