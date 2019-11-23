package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.controller.form.AtualizaClienteForm;
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
        URI uri = uribilder.path("/{id}").buildAndExpand(cliente.getId()).toUri();
        //retornar o 201 de sucesso
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @GetMapping("/{id}")
    public ClienteDTO detalharCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getOne(id);
        return new ClienteDTO(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizaCliente(@PathVariable Long id, @RequestBody @Valid AtualizaClienteForm atualizaClienteForm ){
        Cliente cliente = atualizaClienteForm.atualiza(id, clienteRepository);

    }
}
