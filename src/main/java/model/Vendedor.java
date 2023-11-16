package model;
import dao.*;
public class Vendedor {
    private String email;
    private String senha;
    private String nome;
    private String cpf;

    private int usuarioLogadoId;
    private String usuarioLogadoNome;

    private String usuarioLogadoCPF;

    // Construtor
    public Vendedor(String email, String senha, String nome, String cpf) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Vendedor() {
    }

    // Construtor vazio


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

    public int getUsuarioLogadoId() {
        return usuarioLogadoId;
    }

    public void setUsuarioLogadoId(int usuarioLogadoId) {
        this.usuarioLogadoId = usuarioLogadoId;
    }

    public String getUsuarioLogadoNome(){
        return usuarioLogadoNome;
    }

    public void setUsuarioLogadoNome(String usuarioLogadoNome) {
        this.usuarioLogadoNome = usuarioLogadoNome;
    }

    public String getusuarioLogadoCPF(){
        return usuarioLogadoCPF;
    }

    public void setusuarioLogadoCPF(String usuarioLogadoCPF) {
        this.usuarioLogadoCPF = usuarioLogadoCPF;
    }


}