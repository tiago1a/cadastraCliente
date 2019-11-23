package com.cadastraCliente.cadastraCliente.controller.dto;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;

import java.util.List;

public class ClienteDTO {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public ClienteDTO(Cliente cliente ){
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();

    }

//    public static List<ClienteDTO> converte(List<Object> asList) {
//    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

}
