/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Pedido.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author feeh0
 */
public class PedidoDAO {
    Connection connection;
    public PedidoDAO() throws SQLException, ClassNotFoundException{
        this.connection = Conexao.getConexao();
    }
    
    public LocalDateTime convertDateToLocalDateTime(Date dateToConvert){
        return new java.sql.Timestamp(
            dateToConvert.getTime()).toLocalDateTime();
    }
    
    public Date convertLocalDateTimeToDate(LocalDateTime dateToConvert) {
        return (Date) java.util.Date
        .from(dateToConvert.atZone(ZoneId.systemDefault())
        .toInstant());
    }
    
    public void inserir(Pedido pedido){
        try{
            String sql = "insert into PEDIDOS(data, prazoParaEntrega, fk_cpf)values(?,?,?)";
            try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
                pstm.setDate(1, Date.valueOf(pedido.getData().toLocalDate()));
                pstm.setDate(2, Date.valueOf(pedido.getPrazoParaEntrega().toLocalDate()));
                pstm.setString(3, pedido.getCpfCliente());
                
                pstm.execute();
            }
            
            System.out.println("Pedido adicionado!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void update(Pedido pedido){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String sql = "update PEDIDOS set data=?, prazoParaEntrega=?, fk_cpf=? where id_pedido=?";
        PreparedStatement pstm;
        try {
            pstm = this.connection.prepareStatement(sql);
            pstm.setDate(1, convertLocalDateTimeToDate(pedido.getData()));
            pstm.setDate(2, convertLocalDateTimeToDate(pedido.getPrazoParaEntrega()));
            pstm.setString(3, pedido.getCpfCliente());
            pstm.setInt(4, pedido.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void remove(int pedido) throws SQLException{
        PreparedStatement pstm;
        String sql = "delete from PEDIDOS where id_pedido=?";
        try{
            pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, pedido);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public ArrayList<Pedido> get(){
        ArrayList<Pedido> pedidos = new ArrayList();
        try {            
            String sql = "SELECT p.*, c.nome FROM PEDIDOS p inner join CLIENTES c on p.fk_cpf=c.cpf;";
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                
                while (resultSet.next()) {
                    Pedido pedido;
                    pedido = new Pedido(resultSet.getInt("id_pedido"), LocalDateTime.parse(resultSet.getDate("data").toString() + " 00:00", formatter), LocalDateTime.parse(resultSet.getDate("prazoParaEntrega").toString() + " 00:00", formatter), resultSet.getString("fk_cpf"), resultSet.getString("nome"));
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
        
        return (pedidos);
    }
    
    public Pedido getMaisAntigo(String cpf){
        try {            
            String sql = "SELECT * FROM PEDIDOS p inner join CLIENTES c on p.fk_cpf=c.cpf ORDER BY(data) DESC LIMIT(1) where c.cpf='"+cpf+"'";
            
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                Pedido pedido = new Pedido(resultSet.getInt("id_pedido"), convertDateToLocalDateTime(resultSet.getDate("data")), convertDateToLocalDateTime(resultSet.getDate("prazoParaEntrega")), resultSet.getString("fk_cpf"), resultSet.getString("nome"));
                return (pedido);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
    }
}
