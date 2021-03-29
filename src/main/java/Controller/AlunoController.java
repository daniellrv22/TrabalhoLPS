/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aluno;
import dao.AlunoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class AlunoController {
    
     public int salvar(int id, String nome, String cpf, String endereco, int idade, float mensalidade) throws SQLException, ParseException{
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEndereco(endereco);
        aluno.setIdade(idade);
        aluno.setMensalidade(Float.valueOf(mensalidade));
        AlunoDAO dao = new AlunoDAO();
        
        return AlunoDAO.getInstance().editar(aluno);
    }
     
     public void delete(int id) throws SQLException{
        AlunoDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return AlunoDAO.getInstance().index();
    }
    
}
