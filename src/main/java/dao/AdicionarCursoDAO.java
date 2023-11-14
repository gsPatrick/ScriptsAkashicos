package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdicionarCursoDAO {
    private Connection connection;

    public AdicionarCursoDAO() {
        connection = Conexao.getConecction();
    }

    public void adicionarCurso(Curso curso, String nomeDono) {
        try {
            // Antes de adicionar o curso, obtenha o ID do vendedor pelo nome
            int idDono = obterIdVendedorPorNome(nomeDono);

            if (idDono == -1) {
                throw new RuntimeException("Vendedor não encontrado");
            }

            String sql = "INSERT INTO adicionarcurso (nomeCurso, resumoCurso, conteudoCurso, valorCurso, donoCurso) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, curso.getNomeCurso());
            statement.setString(2, curso.getResumoCurso());
            statement.setString(3, curso.getConteudoCurso());
            statement.setDouble(4, curso.getValorCurso());
            statement.setInt(5, idDono); // Adiciona o id do dono como a chave estrangeira

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao adicionar curso no banco de dados");
        }
    }

    public void atualizarCurso(Curso novoCurso) {
        try {
            String sql = "UPDATE adicionarcurso SET nomeCurso=?, resumoCurso=?, conteudoCurso=?, valorCurso=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoCurso.getNomeCurso());
            statement.setString(2, novoCurso.getResumoCurso());
            statement.setString(3, novoCurso.getConteudoCurso());
            statement.setDouble(4, novoCurso.getValorCurso());
            statement.setInt(5, novoCurso.getIdDoCurso());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar curso no banco de dados");
        }
    }


    private int obterIdVendedorPorNome(String nomeVendedor) {
        try {
            String sql = "SELECT id FROM vendedor WHERE nome=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeVendedor);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao obter ID do vendedor por nome");
        }

        return -1;
    }


    //SOBRE NOME

    public String obterNomeCursoPorId(int id) {
        try {
            String sql = "SELECT nomeCurso FROM adicionarcursos WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("nomeCurso");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao obter nome do curso do banco de dados");
        }

        return null;
    }

    // Método para atualizar o nome do curso por ID
    public void atualizarNomeCursoPorId(int id, String novoNome) {
        try {
            String sql = "UPDATE adicionarcursos SET nomeCurso=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoNome);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar nome do curso no banco de dados");
        }
    }


    // SOBRE RESUMO

    public String obterResumoCursoPorId(int id) {
        try {
            String sql = "SELECT resumoCurso FROM adicionarcursos WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("resumoCurso");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao obter resumo do curso do banco de dados");
        }

        return null;
    }

    public void atualizarResumoCursoPorId(int id, String novoResumo) {
        try {
            String sql = "UPDATE adicionarcursos SET resumoCurso=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoResumo);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar resumo do curso no banco de dados");
        }
    }

    //SOBRE CONTEUDO

    public String obterConteudoCursoPorId(int id) {
        try {
            String sql = "SELECT conteudoCurso FROM adicionarcursos WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("conteudoCurso");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao obter resumo do curso do banco de dados");
        }

        return null;
    }

    public void atualizarConteudoCursoPorId(int id, String novoConteudo) {
        try {
            String sql = "UPDATE adicionarcursos SET conteudoCurso=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoConteudo);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar resumo do curso no banco de dados");
        }
    }


    // sOBRE VALOR

    public double obterValorCursoPorId(int id) {
        try {
            String sql = "SELECT valorCurso FROM adicionarcursos WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("valorCurso");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao obter valor do curso do banco de dados");
        }

        return 0.0; // ou outra valor padrão, dependendo do seu contexto
    }

    // Método para atualizar o valor do curso por ID
    public void atualizarValorCursoPorId(int id, double novoValor) {
        try {
            String sql = "UPDATE adicionarcursos SET valorCurso=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, novoValor);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar valor do curso no banco de dados");
        }
    }


    public static class Curso {
        private String nomeCurso;
        private String resumoCurso;
        private String conteudoCurso;
        private double valorCurso;
        private int idDoCurso;

        // Construtor vazio
        public Curso() {
        }

        // Construtor normal
        public Curso(String nomeCurso, String resumoCurso, String conteudoCurso, double valorCurso) {
            this.nomeCurso = nomeCurso;
            this.resumoCurso = resumoCurso;
            this.conteudoCurso = conteudoCurso;
            this.valorCurso = valorCurso;
        }

        // Mantenha o construtor original com o ID
        public Curso(String nomeCurso, String resumoCurso, String conteudoCurso, double valorCurso, int idDoCurso) {
            this(nomeCurso, resumoCurso, conteudoCurso, valorCurso); // Chama o construtor sem o ID
            this.idDoCurso = idDoCurso;
        }



        // Getters e Setters

        public String getNomeCurso() {
            return nomeCurso;
        }

        public void setNomeCurso(String nomeCurso) {
            this.nomeCurso = nomeCurso;
        }

        public String getResumoCurso() {
            return resumoCurso;
        }

        public void setResumoCurso(String resumoCurso) {
            this.resumoCurso = resumoCurso;
        }

        public String getConteudoCurso() {
            return conteudoCurso;
        }

        public void setConteudoCurso(String conteudoCurso) {
            this.conteudoCurso = conteudoCurso;
        }

        public double getValorCurso() {
            return valorCurso;
        }

        public void setValorCurso(double valorCurso) {
            this.valorCurso = valorCurso;
        }

        public int getIdDoCurso() {
            return idDoCurso;
        }

        public void setIdDoCurso (int idDoCurso) {
            this.idDoCurso = idDoCurso;
        }

    }
}


