/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.ConexaoDAO;
import Model.Instrutor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class InstrutorDAO {
    
    private static InstrutorDAO instancia;
    
    public static InstrutorDAO getInstance() {
        if (instancia == null) {
            instancia = new InstrutorDAO();
        }
        return instancia;
    }
    
    public InstrutorDAO() {
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_instrutor"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_instrutor WHERE id_instrutor = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }
    
    public int editar(Instrutor instrutor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("instrutor" + instrutor.getId( ));
        try {
            if (instrutor.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_instrutor (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, instrutor.getNome());
                ps.setString(2, instrutor.getCpf());

                ps.setString(3, instrutor.getEndereco());
                ps.setInt(4, instrutor.getIdade());
                ps.setFloat(5, instrutor.getSalario());
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_instrutor SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_instrutor = ?");
                ps.setString(1, instrutor.getNome());
                ps.setString(2, instrutor.getCpf());
                ps.setString(3, instrutor.getEndereco());
                ps.setInt(4, instrutor.getIdade());
                ps.setFloat(5, instrutor.getSalario());
                ps.setInt(6, instrutor.getId());
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
