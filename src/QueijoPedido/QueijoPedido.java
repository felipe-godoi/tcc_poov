/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueijoPedido;

/**
 *
 * @author feeh0
 */
public class QueijoPedido {

    private int Id;
    private int idQueijo;
    private int idPedido;
    private float quantidade;

    @Override
    public String toString() {
        return "QueijoPedido{" + "Id=" + Id + ", idQueijo=" + idQueijo + ", idPedido=" + idPedido + ", quantidade=" + quantidade + '}';
    }

    public QueijoPedido(int Id, int idQueijo, int idPedido, float quantidade) {
        this.Id = Id;
        this.idQueijo = idQueijo;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdQueijo() {
        return idQueijo;
    }

    public void setIdQueijo(int idQueijo) {
        this.idQueijo = idQueijo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

}
