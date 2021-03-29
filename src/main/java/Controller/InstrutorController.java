/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Instrutor;
import dao.InstrutorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class InstrutorController {
    
     public int salvar(int id, String nome, String cpf, String endereco, int idade, float salario) throws SQLException, ParseException{
        Instrutor instrutor = new Instrutor();
        instrutor.setId(id);
        instrutor.setNome(nome);
        instrutor.setCpf(cpf);
        instrutor.setEndereco(endereco);
        instrutor.setIdade(idade);
        instrutor.setSalario(Float.valueOf(salario));
        InstrutorDAO dao = new InstrutorDAO();
        
        return InstrutorDAO.getInstance().editar(instrutor);
    }
     
     public void delete(int id) throws SQLException{
        InstrutorDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return InstrutorDAO.getInstance().index();
    }
    
}
