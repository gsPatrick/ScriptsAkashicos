package model;
import java.time.LocalDate;

public class Conta {
    private int id;
    private int idConta;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String senha;
    private String tipoConta;

    // Construtor vazio
    public Conta() {

    }

    // Construtor com parâmetros
    public Conta(String nome, String email, String cpf, LocalDate dataNascimento, String senha, String tipoConta, int idConta) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.tipoConta = tipoConta;
        this.idConta = idConta;
    }

    // Getters e setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoConta() {return tipoConta;}

    public void setTipoConta (String tipoConta) {this.tipoConta = tipoConta;}

    public int getIdConta() {
        return id;
    }

    public void setIdConta(int idConta) {
        this.id = idConta;
    }

}
