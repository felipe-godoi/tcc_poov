/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queijo;

/**
 *
 * @author feeh0
 */
public class Queijo {
    private int Id;
    private float peso;
    private float valorPorKg;
    private String tipoDoQueijo;
    private float temperaturaIdeal;

    @Override
    public String toString() {
        return "Queijo{" + "Id=" + Id + ", peso=" + peso + ", valorPorKg=" + valorPorKg + ", tipoDoQueijo=" + tipoDoQueijo + ", temperaturaIdeal=" + temperaturaIdeal + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getValorPorKg() {
        return valorPorKg;
    }

    public void setValorPorKg(float valorPorKg) {
        this.valorPorKg = valorPorKg;
    }

    public String getTipoDoQueijo() {
        return tipoDoQueijo;
    }

    public void setTipoDoQueijo(String tipoDoQueijo) {
        this.tipoDoQueijo = tipoDoQueijo;
    }

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public Queijo(int Id, float peso, float valorPorKg, String tipoDoQueijo, float temperaturaIdeal) {
        this.Id = Id;
        this.peso = peso;
        this.valorPorKg = valorPorKg;
        this.tipoDoQueijo = tipoDoQueijo;
        this.temperaturaIdeal = temperaturaIdeal;
    }
}
