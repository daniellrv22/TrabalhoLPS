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
public class Nutricionista {
    private String tabelaNome = "tbl_nutricionista";
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private float salario;
    
     public Nutricionista() {
        
    }

    public Nutricionista(int id, String nome, String cpf, String endereco, int idade, float salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.salario = salario;
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
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_nutricionista WHERE id_nutricionista = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }
    
    public int editar(Nutricionista nutricionista) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("nutricionista" + nutricionista.getId( ));
        try {
            if (nutricionista.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_nutricionista (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, nutricionista.getNome());
                ps.setString(2, nutricionista.getCpf());

                ps.setString(3, nutricionista.getEndereco());
                ps.setInt(4, nutricionista.getIdade());
                ps.setFloat(5, nutricionista.getSalario());
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_nutricionista SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_nutricionista = ?");
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
