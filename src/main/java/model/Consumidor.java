package model;
import dao.*;
public class Consumidor {
    private String email;
    private String senha;
    private String nome;
    private String cpf;

    private int usuarioLogadoIdConsumidor;

    private String usuarioLogadoNomeConsumidor;


    // Construtor
    public Consumidor(String email, String senha, String nome, String cpf) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Consumidor() {
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getUsuarioLogadoIdConsumidor() {
        return usuarioLogadoIdConsumidor;
    }

    public void setUsuarioLogadoIdConsumidor(int usuarioLogadoIdConsumidor) {
        this.usuarioLogadoIdConsumidor = usuarioLogadoIdConsumidor;
    }

    public String getusuarioLogadoNomeConsumidor() {
        return usuarioLogadoNomeConsumidor;
    }

    public void setusuarioLogadoNomeConsumidor(String usuarioLogadoNomeConsumidor) {
        this.usuarioLogadoNomeConsumidor = usuarioLogadoNomeConsumidor;
    }
}