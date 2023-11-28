package model;

import java.util.ArrayList;
import java.util.List;

public class Denuncia {
    private int id;
    private String tipoDeProblema;
    private String descricao;
    private List<String> foto;
    private String rua;
    private String bairro;
    private String comp;
    private String status;

    public Denuncia(){       
    };
    
    public Denuncia(String bairro,String rua, String comp,String descricao){
    this.bairro = bairro;
    this.rua = rua;
    this.comp = comp;    
    this.descricao = descricao;
    
    }
     public ArrayList getLista(){
     // DenunciaDAO.denunciasDb;
     return null;
    }

    public boolean cadastro( String bairro,String rua, String comp, String descricao){
        this.bairro = bairro;
        this.rua = rua;
        this.comp = comp;
        this.descricao = descricao;

        
        return true;
    }
    
    public void  atualizarstatus(){

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeProblema() {
        return tipoDeProblema;
    }

    public void setTipoDeProblema(String tipoDeProblema) {
        this.tipoDeProblema = tipoDeProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public Denuncia setDescricao(String descricao) {
        this.descricao = descricao;
        return null;
    }

    public List<String> getFoto() {
        return foto;
    }

    public void setFoto(List<String> foto) {
        this.foto = foto;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "id=" + id +
                ", tipoDeProblema='" + tipoDeProblema + '\'' +
                ", descricao='" + descricao + '\'' +
                ", foto=" + foto +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", comp='" + comp + '\'' +
                ", status='" + status + '\'' +
                ", lista=" + getLista() +
                ", localizacao='" + getLocalizacao() + '\'' +
                '}';
    }
}
