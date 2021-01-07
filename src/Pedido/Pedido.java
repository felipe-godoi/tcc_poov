/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedido;

import java.time.LocalDateTime;

/**
 *
 * @author feeh0
 */
public class Pedido {
    private int Id;
    private LocalDateTime data;
    private LocalDateTime prazoParaEntrega;
    private String cpfCliente;
    private String nomeCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "Id=" + Id + ", data=" + data + ", prazoParaEntrega=" + prazoParaEntrega + ", cpfCliente=" + cpfCliente + ", nomeCliente=" + nomeCliente + '}';
    }

    public Pedido(int Id, LocalDateTime data, LocalDateTime prazoParaEntrega, String cpfCliente, String nomeCliente) {
        this.Id = Id;
        this.data = data;
        this.prazoParaEntrega = prazoParaEntrega;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getPrazoParaEntrega() {
        return prazoParaEntrega;
    }

    public void setPrazoParaEntrega(LocalDateTime prazoParaEntrega) {
        this.prazoParaEntrega = prazoParaEntrega;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
}
