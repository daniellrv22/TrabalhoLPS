/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.Aluno;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class AlunoDAO {
    
    private static AlunoDAO instancia;
    
    public static AlunoDAO getInstance() {
        if (instancia == null) {
            instancia = new AlunoDAO();
        }
        return instancia;
    }
    
    public AlunoDAO() {
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_aluno"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_aluno WHERE id_aluno = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Aluno aluno) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("aluno" + aluno.getId( ));
        try {
            if (aluno.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_aluno (nome, cpf, endereco, idade, mensalidade) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCpf());

                ps.setString(3, aluno.getEndereco());
                ps.setInt(4, aluno.getIdade());
                ps.setFloat(5, aluno.getMensalidade());
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_aluno SET nome = ?, cpf = ?, endereco = ?, idade = ?, mensalidade = ? WHERE id_aluno = ?");
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCpf());
                ps.setString(3, aluno.getEndereco());
                ps.setInt(4, aluno.getIdade());
                ps.setFloat(5, aluno.getMensalidade());
                ps.setInt(6, aluno.getId());
            }

        } catch (SQLException e) {
            System.out.println(e + "error");
        }
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int idx = 0;
        if (rs.next()) {
            idx = rs.getInt(1);
        }
        return idx;
    }
    
}
