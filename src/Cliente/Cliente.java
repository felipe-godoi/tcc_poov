/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author feeh0
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String endInstagram;
    private String endFacebook;
    private String cartaoDeCredito;

    @Override
    public String toString() {
        return "Clientes{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", end_instagram=" + endInstagram + ", end_facebook=" + endFacebook + ", cartaoDeCredito=" + cartaoDeCredito + '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndInstagram() {
        return endInstagram;
    }

    public void setEndInstagram(String endInstagram) {
        this.endInstagram = endInstagram;
    }

    public String getEndFacebook() {
        return endFacebook;
    }

    public void setEndFacebook(String endFacebook) {
        this.endFacebook = endFacebook;
    }

    public String getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(String cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public Cliente(String cpf, String nome, String telefone, String endereco, String endInstagram, String endFacebook, String cartaoDeCredito) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.endInstagram = endInstagram;
        this.endFacebook = endFacebook;
        this.cartaoDeCredito = cartaoDeCredito;
    }
    
}
