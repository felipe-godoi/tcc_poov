/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Pedido.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author feeh0
 */
public class PedidosModel extends AbstractTableModel{
    private List<Pedido> pedidos;
    private String[] colunas = {"IdPedido", "Data", "Prazo", "CPF Cliente", "NomeCliente"};
    
    public PedidosModel(){
        pedidos = new ArrayList<Pedido>();
    }
    
    public void addRow(Pedido p){
        this.pedidos.add(p);
        this.fireTableDataChanged();
    }
    
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() {
        return pedidos.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        switch(coluna){
            case 0: return pedidos.get(linha).getId();
            case 1: return pedidos.get(linha).getData().toLocalDate().format(formatter);
            case 2: return pedidos.get(linha).getPrazoParaEntrega().toLocalDate().format(formatter);
            case 3: return pedidos.get(linha).getCpfCliente();
            case 4: return pedidos.get(linha).getNomeCliente();
        }  
        return null;
    }
    
    public void removeRow(int linha){
        this.pedidos.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Pedido get(int linha){
        return this.pedidos.get(linha);
    }
    
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        if (column == 0 || column == 3)
            return Integer.class;
        else if (column == 1 || column == 2)
            return LocalDateTime.class;
        else
            return String.class;
    }
}
