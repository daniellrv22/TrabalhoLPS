/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Atendente;
import dao.AtendenteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class AtendenteController {
    
    public int salvar(int id, String nome, String cpf, String endereco, int idade, float salario) throws SQLException, ParseException{
        Atendente atendente = new Atendente();
        atendente.setId(id);
        atendente.setNome(nome);
        atendente.setCpf(cpf);
        atendente.setEndereco(endereco);
        atendente.setIdade(idade);
        atendente.setSalario(Float.valueOf(salario));
        AtendenteDAO dao = new AtendenteDAO();
        
        return AtendenteDAO.getInstance().editar(atendente);
    }
     
     public void delete(int id) throws SQLException{
        AtendenteDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return AtendenteDAO.getInstance().index();
    }
    
}
