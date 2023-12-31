package model;

import controller.DenunciaService;

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
    private int cidadaoId;
    private String localizacao;

    public Denuncia() {
    }


   /* public Denuncia(String descricao, String rua, String bairro, String comp, int cidadaoId) {
        this.descricao = descricao;
        this.rua = rua;
        this.bairro = bairro;
        this.comp = comp;
        this.cidadaoId = cidadaoId;
    }*/

    public Denuncia(String descricao, String rua, String bairro, String comp) {
        this.descricao = descricao;
        this.rua = rua;
        this.bairro = bairro;
        this.comp = comp;
    }


    public Denuncia(int id, String descricao, String localizacao) {
        this.id = id;
        this.descricao = descricao;
        this.localizacao = localizacao;
    }

    public boolean cadastro(String bairro, String rua, String comp, String descricao) {
        this.bairro = bairro;
        this.rua = rua;
        this.comp = comp;
        this.descricao = descricao;

        return true;
    }

    public boolean cadastro2(String descricao) {
        this.descricao = descricao;
        Denuncia denuncia = new Denuncia(bairro, rua, comp, descricao);
        //       DenunciaDAO.denunciasDb.add(denuncia);
        return true;
    }


    public String getLocalizacao() {
        return bairro + rua + comp;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacaoC() {
        return localizacao;
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

    public void atualizarstatus() {

    }

    public int getCidadiaId() {
        return cidadaoId;
    }

    public void setCidadiaId(int cidadiaId) {
        this.cidadaoId = cidadiaId;

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

    public List<Denuncia> getLista() {
        DenunciaService denunciaService = new DenunciaService();
        List<Denuncia> listaDenuncia = denunciaService.listarDenuncia();

        return listaDenuncia;
    }
}
