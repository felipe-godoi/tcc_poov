/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Queijo.Queijo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author feeh0
 */
public class QueijosModel extends AbstractTableModel {
    private List<Queijo> queijos;
    private String[] colunas = {"Id", "Tipo", "Peso", "Valor KG", "Temperatura"};
    
    public QueijosModel(){
        queijos = new ArrayList<Queijo>();
    }
    
    public void addRow(Queijo q){
        this.queijos.add(q);
        this.fireTableDataChanged();
    }
    
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() {
        return queijos.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return queijos.get(linha).getId();
            case 1: return queijos.get(linha).getTipoDoQueijo();
            case 2: return queijos.get(linha).getPeso();
            case 3: return queijos.get(linha).getValorPorKg();
            case 4: return queijos.get(linha).getTemperaturaIdeal();
        }  
        return null;
    }
    
    public void removeRow(int linha){
        this.queijos.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Queijo get(int linha){
        return this.queijos.get(linha);
    }
    
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        if (column == 0)
            return Integer.class;
        else if (column == 2 || column == 3 || column == 4)
            return Float.class;
        else
            return String.class;
    }
}
