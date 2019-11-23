package com.cadastraCliente.cadastraCliente.controller.form;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {
    //dados que estão chegando do cliente

    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty @Length(min = 3, max = 100, message = "Nome deve ter entre 3 e 100")
    private String nome;
    @NotNull @NotEmpty
    private String telefone;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String senha;

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

    public Cliente converter() {
        return new Cliente(cpf, nome, telefone, email, senha);

    }
}
