package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.controller.form.ClienteForm;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.cadastraCliente.cadastraCliente.repository.ClienteRepository;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
   public List<ClienteDTO> listaCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return ClienteDTO.converter(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadsatrarCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uribilder){
        //converter form para cliente
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);

        //montando o retorno de sucesso
        URI uri = uribilder.path("/{id}").buildAndExpand(cliente.getCpf()).toUri();
        //retornar o 201 de sucesso
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @GetMapping("/{cpf}")
    public ClienteDTO detalharCliente(@PathVariable String cpf) {
        Cliente cliente = clienteRepository.getOne(Long.valueOf(cpf));
        return new ClienteDTO(cliente);
    }

}
