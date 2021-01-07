/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Queijo.Queijo;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author feeh0
 */
public class QueijoDAO {
    Connection connection;
    public QueijoDAO() throws SQLException, ClassNotFoundException{
        this.connection = Conexao.getConexao();
    }
    
    public void inserir(Queijo queijo){
        try{
            String sql = "insert into QUEIJOS(peso, valorPorKg, tipoDoQueijo, temperaturaIdeal)values(?,?,?,?)";
            try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
                pstm.setFloat(1, queijo.getPeso());
                pstm.setFloat(2, queijo.getValorPorKg());
                pstm.setString(3, queijo.getTipoDoQueijo());
                pstm.setFloat(4, queijo.getTemperaturaIdeal());
                
                pstm.execute();
            }
            
            System.out.println("Queijo adicionado!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void update(Queijo queijo){
        String sql = "update QUEIJOS set peso=?, valorPorKg=?, tipoDoQueijo=?, temperaturaIdeal=? where id_queijo=?";
        PreparedStatement pstm;
        try {
            pstm = this.connection.prepareStatement(sql);
            pstm.setFloat(1, queijo.getPeso());
            pstm.setFloat(2, queijo.getValorPorKg());
            pstm.setString(3,queijo.getTipoDoQueijo());
            pstm.setFloat(4, queijo.getTemperaturaIdeal());
            pstm.setFloat(5, queijo.getId());
            System.out.println(pstm.toString());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void remove(int queijo) throws SQLException{
        PreparedStatement pstm;
        String sql = "delete from QUEIJOS where id_queijo=?";
        try{
            pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, queijo);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public ArrayList<Queijo> get(){
        ArrayList<Queijo> queijos = new ArrayList();
        try {            
            String sql = "SELECT * FROM QUEIJOS";
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                
                while (resultSet.next()) {
                    Queijo queijo;
                    queijo = new Queijo(resultSet.getInt("id_queijo"), resultSet.getFloat("peso"), resultSet.getFloat("valorPorKg"), resultSet.getString("tipoDoQueijo"), resultSet.getFloat("temperaturaIdeal"));
                    queijos.add(queijo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
        
        return (queijos);
    }
    
    public Queijo getOne(int id){
        try {            
            String sql = "SELECT * FROM QUEIJOS where id_queijo='"+id+"'";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Queijo queijo = new Queijo(resultSet.getInt("id_queijo"), resultSet.getFloat("peso"), resultSet.getFloat("valorPorKg"), resultSet.getString("tipoDoQueijo"), resultSet.getFloat("temperaturaIdeal"));
                return (queijo);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
    
    public Queijo getMaisCaro(){
        try {            
            String sql = "SELECT * FROM QUEIJOS ORDER BY(valorPorKg) DESC LIMIT 1";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Queijo queijo = new Queijo(resultSet.getInt("id_queijo"), resultSet.getFloat("peso"), resultSet.getFloat("valorPorKg"), resultSet.getString("tipoDoQueijo"), resultSet.getFloat("temperaturaIdeal"));
                return (queijo);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
    
    public Queijo getMenorTemperatura(){
        try {            
            String sql = "SELECT * FROM QUEIJOS ORDER BY(temperaturaIdeal) ASC LIMIT 1;";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Queijo queijo = new Queijo(resultSet.getInt("id_queijo"), resultSet.getFloat("peso"), resultSet.getFloat("valorPorKg"), resultSet.getString("tipoDoQueijo"), resultSet.getFloat("temperaturaIdeal"));
                return (queijo);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
}
