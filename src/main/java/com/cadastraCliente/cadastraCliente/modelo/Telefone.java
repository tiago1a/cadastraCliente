package com.cadastraCliente.cadastraCliente.modelo;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private int numero;

    @ManyToOne
    @JoinColumn
    Cliente cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
