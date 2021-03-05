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
import java.text.SimpleDateFormat;

/**
 *
 * @author Pichau
 */
public class Aluno {
    
    private String tabelaNome = "tbl_aluno";
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private float mensalidade;



    public Aluno(int id, String nome, String cpf, String endereco, int idade, float mensalidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.mensalidade = mensalidade;
    }

    public Aluno() {
        
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

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
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
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_aluno WHERE id_aluno = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Aluno aluno) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("aluno" + aluno.getId( ));
        try {
            if (aluno.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_aluno (nome, cpf, endereco, idade, mensalidade) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCpf());

                ps.setString(3, aluno.getEndereco());
                ps.setInt(4, aluno.getIdade());
                ps.setFloat(5, aluno.getMensalidade());
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_aluno SET nome = ?, cpf = ?, endereco = ?, idade = ?, mensalidade = ? WHERE id_aluno = ?");
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
