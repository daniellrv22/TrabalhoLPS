/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Atendente;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class AtendenteDAO {
    
    private static AtendenteDAO instancia;
    
    public static AtendenteDAO getInstance() {
        if (instancia == null) {
            instancia = new AtendenteDAO();
        }
        return instancia;
    }
    
    public AtendenteDAO() {
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_atendente"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_atendente WHERE id_atendente = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }
    
    public int editar(Atendente atendente) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("atendente" + atendente.getId( ));
        try {
            if (atendente.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_atendente (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, atendente.getNome());
                ps.setString(2, atendente.getCpf());

                ps.setString(3, atendente.getEndereco());
                ps.setInt(4, atendente.getIdade());
                ps.setFloat(5, atendente.getSalario());
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_atendente SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_atendente = ?");
                ps.setString(1, atendente.getNome());
                ps.setString(2, atendente.getCpf());
                ps.setString(3, atendente.getEndereco());
                ps.setInt(4, atendente.getIdade());
                ps.setFloat(5, atendente.getSalario());
                ps.setInt(6, atendente.getId());
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
