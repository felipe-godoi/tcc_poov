/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Cliente.Cliente;
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
public class ClienteDAO {
    Connection connection;
    public ClienteDAO() throws SQLException, ClassNotFoundException{
        this.connection = Conexao.getConexao();
    }
    
    public void inserir(Cliente cliente){
        try{
            String sql = "insert into CLIENTES(cpf, nome, telefone, endereco, end_instagram, end_facebook, cartaoDeCredito)values(?,?,?,?,?,?,?)";
            try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
                pstm.setString(1, cliente.getCpf());
                pstm.setString(2, cliente.getNome());
                pstm.setString(3, cliente.getTelefone());
                pstm.setString(4, cliente.getEndereco());
                pstm.setString(5, cliente.getEndInstagram());
                pstm.setString(6, cliente.getEndFacebook());
                pstm.setString(7, cliente.getCartaoDeCredito());
                
                pstm.execute();
                pstm.close();
            }
            
            System.out.println("Cliente adicionado!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void update(Cliente cliente){
        String sql = "update CLIENTES set nome=?, telefone=?, endereco=?, end_instagram=?, end_facebook=?, cartaoDeCredito=? where cpf=?";
        PreparedStatement pstm;
        try {
            pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getTelefone());
            pstm.setString(3, cliente.getEndereco());
            pstm.setString(4, cliente.getEndInstagram());
            pstm.setString(5, cliente.getEndFacebook());
            pstm.setString(6, cliente.getCartaoDeCredito());
            pstm.setString(7, cliente.getCpf());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void remove(String cliente) throws SQLException{
        PreparedStatement pstm;
        String sql = "delete from CLIENTES where cpf=?";
        try{
            pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, cliente);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public ArrayList<Cliente> get(){
        ArrayList<Cliente> clientes = new ArrayList();
        try {            
            String sql = "SELECT * FROM CLIENTES";
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                
                while (resultSet.next()) {
                    Cliente cliente;
                    cliente = new Cliente(resultSet.getString("cpf"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("endereco"), resultSet.getString("end_instagram"), resultSet.getString("end_facebook"), resultSet.getString("cartaoDeCredito"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
        
        return (clientes);
    }
    
    public Cliente getOne(String cpf){
        try {            
            String sql = "SELECT * FROM CLIENTES where cpf='"+cpf+"'";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Cliente cliente = new Cliente(resultSet.getString("cpf"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("endereco"), resultSet.getString("end_instagram"), resultSet.getString("end_facebook"), resultSet.getString("cartaoDeCredito"));
                return (cliente);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
    
    public Cliente getOnePorNome(String nome){
        try {            
            String sql = "SELECT * FROM CLIENTES where nome='"+nome+"'";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Cliente cliente = new Cliente(resultSet.getString("cpf"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("endereco"), resultSet.getString("end_instagram"), resultSet.getString("end_facebook"), resultSet.getString("cartaoDeCredito"));
                return (cliente);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
    
    public int length(){
        ArrayList<Cliente> clientes = new ArrayList();
        try {            
            String sql = "SELECT * FROM CLIENTES";
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                
                while (resultSet.next()) {
                    Cliente cliente = new Cliente(resultSet.getString("cpf"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("endereco"), resultSet.getString("end_instagram"), resultSet.getString("end_facebook"), resultSet.getString("cartaoDeCredito"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (0);
        }
        
        return (clientes.size());
    }
}
