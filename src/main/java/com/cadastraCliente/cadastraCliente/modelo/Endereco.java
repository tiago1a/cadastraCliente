package com.cadastraCliente.cadastraCliente.modelo;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    @ManyToOne
    private Cliente cliente;
}
