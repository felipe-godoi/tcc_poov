/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Cliente.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author feeh0
 */
public class ClientesModel extends AbstractTableModel{
    private List<Cliente> clientes;
    private String[] colunas = {"CPF", "Nome", "Telefone", "Endereço", "Instagram", "Facebook", "Cartão de Crédito"};
    
    public ClientesModel(){
        clientes = new ArrayList<Cliente>();
    }
    
    public void addRow(Cliente c){
        this.clientes.add(c);
        this.fireTableDataChanged();
    }
    
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return clientes.get(linha).getCpf();
            case 1: return clientes.get(linha).getNome();
            case 2: return clientes.get(linha).getTelefone();
            case 3: return clientes.get(linha).getEndereco();
            case 4: return clientes.get(linha).getEndInstagram();
            case 5: return clientes.get(linha).getEndFacebook();
            case 6: return clientes.get(linha).getCartaoDeCredito();
        }  
        return null;
    }
    
    public void removeRow(int linha){
        this.clientes.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Cliente get(int linha){
        return this.clientes.get(linha);
    }
    
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }
}
