/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO.FuncionarioGovernoDAO;
import model.FuncionarioGoverno;
/**
 *
 * @author arian
 */
public class FuncionarioService {
    
    FuncionarioGoverno funcionario = new FuncionarioGoverno();
    
    public boolean consultaFunc(String nome, String senha){
        FuncionarioGovernoDAO funcDAO = new FuncionarioGovernoDAO();
        this.funcionario = funcDAO.pesquisar(nome,senha);
        if (this.funcionario != null){
            return true;
        }else{
            return false;
        }
    }
    public FuncionarioGoverno getFuncionario(){
        return funcionario;
        }
    }

