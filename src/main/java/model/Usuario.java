package model;

public class Usuario {
    private String nome;
    private String senha;
    private int idade;
    private String email;

    public void cadastrar(){

    }

    public Usuario() {
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

   
}
