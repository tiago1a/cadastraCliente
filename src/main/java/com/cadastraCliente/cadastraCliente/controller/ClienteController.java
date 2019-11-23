package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.controller.form.ClienteForm;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cadastraCliente.cadastraCliente.repository.ClienteRepository;

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
    public void cadsatrarCliente(@RequestBody ClienteForm clienteForm){
        //converter form para cliente
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);
    }

}
