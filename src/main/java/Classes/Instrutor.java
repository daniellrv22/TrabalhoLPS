/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class Instrutor {
    private String tabelaNome = "tbl_instrutor";
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private float salario;

    public Instrutor(int id, String nome, String cpf, String endereco, int idade, float salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.salario = salario;
    }
    
    
    public Instrutor() {
   
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement(String.format("SELECT * FROM %s", tabelaNome));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_instrutor WHERE id_instrutor = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }
    
    public int editar(Instrutor instrutor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("instrutor" + instrutor.getId( ));
        try {
            if (instrutor.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_instrutor (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, instrutor.getNome());
                ps.setString(2, instrutor.getCpf());

                ps.setString(3, instrutor.getEndereco());
                ps.setInt(4, instrutor.getIdade());
                ps.setFloat(5, instrutor.getSalario());
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_instrutor SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_instrutor = ?");
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
