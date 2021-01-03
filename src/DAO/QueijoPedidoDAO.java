/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import QueijoPedido.QueijoPedido;
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
public class QueijoPedidoDAO {
    Connection connection;
    public QueijoPedidoDAO() throws SQLException, ClassNotFoundException{
        this.connection = Conexao.getConexao();
    }
    
    public void inserir(QueijoPedido queijoPedido){
        try{
            String sql = "insert into QUEIJO_PEDIDOS(quantidade, fk_id_pedido, fk_id_queijo)values(?,?,?)";
            try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
                pstm.setFloat(1, queijoPedido.getQuantidade());
                pstm.setInt(2, queijoPedido.getIdPedido());
                pstm.setInt(3, queijoPedido.getIdQueijo());
                
                pstm.execute();
            }
            
            System.out.println("Queijo Pedido adicionado!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public void remove(int queijoPedido) throws SQLException{
        PreparedStatement pstm;
        String sql = "delete from QUEIJO_PEDIDOS where id_queijo_pedido=?";
        try{
            pstm = this.connection.prepareStatement(sql);
            pstm.setInt(1, queijoPedido);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
        }
    }
    
    public ArrayList<QueijoPedido> get(){
        ArrayList<QueijoPedido> queijoPedidos = new ArrayList();
        try {            
            String sql = "SELECT * FROM QUEIJO_PEDIDOS";
            try (Statement statement = this.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                
                while (resultSet.next()) {
                    QueijoPedido queijoPedido;
                    queijoPedido = new QueijoPedido(resultSet.getInt("id_queijo_pedido"), resultSet.getInt("fk_id_queijo"), resultSet.getInt("fk_id_pedido"), resultSet.getFloat("quantidade"));
                    queijoPedidos.add(queijoPedido);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            return (null);
        }
        
        return (queijoPedidos);
    }
}
