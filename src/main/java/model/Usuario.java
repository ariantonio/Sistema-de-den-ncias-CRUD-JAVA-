package model;

import controller.CidadaoService;

import java.util.List;
import java.util.ArrayList;



public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private int idade; //não tem no diagrama (remover do codigo ou acrecentar ao diagrama)
    private String email;
    private String data_nascimento;

    public Usuario() {
    }
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String nomeUsuario, String senha, int idade, String email) {
        this.nome = nomeUsuario;
        this.senha = senha;
        this.idade = idade;
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getLista() {
        CidadaoService cidadaoService = new CidadaoService();
        List<Cidadao> listaCidadao = cidadaoService.listarCidadao();

        return listaCidadao;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
