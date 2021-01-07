/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author feeh0
 */
public class Conexao {
    public static Connection getConexao() throws SQLException{
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc", "root", "123456");
            System.out.println("Connected to MySQL database");
        } catch (SQLException e) {
            System.out.println("\n Erro ao conectar: "+e.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println("\n Erro ao conectar: "+ex.toString());
        }
        
        return (connection);
    }
}
