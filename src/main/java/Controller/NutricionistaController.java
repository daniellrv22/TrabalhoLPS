/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Nutricionista;
import dao.NutricionistaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class NutricionistaController {
    
     public int salvar(int id, String nome, String cpf, String endereco, int idade, float salario) throws SQLException, ParseException{
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setId(id);
        nutricionista.setNome(nome);
        nutricionista.setCpf(cpf);
        nutricionista.setEndereco(endereco);
        nutricionista.setIdade(idade);
        nutricionista.setSalario(Float.valueOf(salario));
        NutricionistaDAO dao = new NutricionistaDAO();
        
        return NutricionistaDAO.getInstance().editar(nutricionista);
    }
     
     public void delete(int id) throws SQLException{
        NutricionistaDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return NutricionistaDAO.getInstance().index();
    }
    
}
