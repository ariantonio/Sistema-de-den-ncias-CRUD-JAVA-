package model;
import DAO.FuncionarioGovernoDAO;
public class FuncionarioGoverno extends Usuario {
    private String orgao;
    private String identificacao;
    private String cargo;


    public void excluir_denuncia(){

    }
    
     public FuncionarioGoverno() {
    }
     public FuncionarioGoverno(String nome, String senha){
         super(nome, senha);
     }

    public FuncionarioGoverno(String orgao, String identificacao, String cargo) {
        this.orgao = orgao;
        this.identificacao = identificacao;
        this.cargo = cargo;
    }

    public FuncionarioGoverno(String nome, String senha, String email, String orgao, String identificacao, String cargo) {
        super(nome, senha, email);
        this.orgao = orgao;
        this.identificacao = identificacao;
        this.cargo = cargo;
    }

    public FuncionarioGoverno(String nomeUsuario, String senha, int idade, String email, String orgao, String identificacao, String cargo) {
        super(nomeUsuario, senha, idade, email);
        this.orgao = orgao;
        this.identificacao = identificacao;
        this.cargo = cargo;
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


    
    
    

}
