/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class Conexao {
    
    private static Connection conn = null;

    private Conexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/academia";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("New connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connection() throws SQLException {
        if(conn == null)
            new Conexao();
        return conn;
    }
    
}
