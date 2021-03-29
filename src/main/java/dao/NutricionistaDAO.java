/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.ConexaoDAO;
import Model.Nutricionista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class NutricionistaDAO {
    
    
    private static NutricionistaDAO instancia;
    
    public static NutricionistaDAO getInstance() {
        if (instancia == null) {
            instancia = new NutricionistaDAO();
        }
        return instancia;
    }
    
    public NutricionistaDAO() {
    }
    
     public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_nutricionista"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_nutricionista WHERE id_nutricionista = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }
    
    public int editar(Nutricionista nutricionista) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("nutricionista" + nutricionista.getId( ));
        try {
            if (nutricionista.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_nutricionista (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, nutricionista.getNome());
                ps.setString(2, nutricionista.getCpf());

                ps.setString(3, nutricionista.getEndereco());
                ps.setInt(4, nutricionista.getIdade());
                ps.setFloat(5, nutricionista.getSalario());
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_nutricionista SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_nutricionista = ?");
                ps.setString(1, nutricionista.getNome());
                ps.setString(2, nutricionista.getCpf());
                ps.setString(3, nutricionista.getEndereco());
                ps.setInt(4, nutricionista.getIdade());
                ps.setFloat(5, nutricionista.getSalario());
                ps.setInt(6, nutricionista.getId());
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
