package com.cadastraCliente.cadastraCliente.controller.dto;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {
    //dados que estou buscando
    private long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String usuario;
    private String senha;

    public ClienteDTO(Cliente cliente ) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.usuario = cliente.getUsuario();
        this.senha = cliente.getSenha();
    }

    public static List<ClienteDTO> converter(List<Cliente> topicos) {
        return topicos.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

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

    public String getSenha() {
        return senha;
    }
    public String getUsuario() {
        return usuario;
    }

}
