package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;
import menu.*;

public class AdicionarCursoDAO {
    private Connection connection;

    public AdicionarCursoDAO() {
        connection = Conexao.getConecction();
    }

    public void adicionarCurso(String nomeCurso, String resumoCurso, String conteudoCurso, double valorCurso, int idUsuarioLogado, String nomeUsuarioLogado) {
        String sql = "INSERT INTO adicionarcurso (nomecurso, resumocurso, conteudocurso, valorcurso, iddonocurso, nomedonocurso) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeCurso);
            stmt.setString(2, resumoCurso);
            stmt.setString(3, conteudoCurso);
            stmt.setDouble(4, valorCurso);
            stmt.setInt(5, idUsuarioLogado);
            stmt.setString(6, nomeUsuarioLogado);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void atualizarNomeCurso(int idDoCurso, String novoNome) {
        String sql = "UPDATE adicionarcurso SET nomecurso = ? WHERE iddocurso = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoNome);
            stmt.setInt(2, idDoCurso);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarResumoCurso(int idDoCurso, String novoResumo) {
        String sql = "UPDATE adicionarcurso SET resumocurso = ? WHERE iddocurso = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoResumo);
            stmt.setInt(2, idDoCurso);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarConteudoCurso(int idDoCurso, String novoConteudo) {
        String sql = "UPDATE adicionarcurso SET conteudocurso = ? WHERE iddocurso = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoConteudo);
            stmt.setInt(2, idDoCurso);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarValorCurso(int idDoCurso, double novoValor) {
        String sql = "UPDATE adicionarcurso SET valorcurso = ? WHERE iddocurso = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, novoValor);
            stmt.setInt(2, idDoCurso);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
