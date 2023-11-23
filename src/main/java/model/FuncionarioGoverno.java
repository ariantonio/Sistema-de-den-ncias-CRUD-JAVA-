package model;

public class FuncionarioGoverno {
    private String nome;
    private String email;
    private String orgao;
    private String identificacao;
    private String cargo;
    private String senha;
    
    
     public FuncionarioGoverno() {
    }


    public FuncionarioGoverno(String nome, String email, String orgao, String identificacao, String cargo, String senha) {
        this.nome = nome;
        this.nome = email;
        this.orgao = orgao;
        this.identificacao = identificacao;
        this.cargo = cargo;
        this.senha = senha;
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

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    
    public void cadastro(){

    }
}
