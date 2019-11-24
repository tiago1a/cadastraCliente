package com.cadastraCliente.cadastraCliente.controller.form;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import com.cadastraCliente.cadastraCliente.modelo.Endereco;
import com.cadastraCliente.cadastraCliente.repository.ClienteRepository;
import com.cadastraCliente.cadastraCliente.repository.EnderecoRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm{
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
    private String usuario;
    @NotNull @NotEmpty
    private String senha;

    private String cep;
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Cliente converter() {
        return new Cliente(cpf, nome, telefone, email, usuario,senha);
    }
}
