package com.cadastraCliente.cadastraCliente.controller.form;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;

public class ClienteForm {
    //dados que estão chegando do cliente
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

    public Cliente converter() {
        return new Cliente(cpf, nome, telefone, email, senha);

    }
}
