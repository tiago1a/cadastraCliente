package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cadastraCliente.cadastraCliente.repository.ClienteRepository;

import java.util.List;

@Controller
public class ClienteController {


    @Autowired
    public ClienteRepository clienteRepository;

    @RequestMapping("/cliente")
    @ResponseBody
   public List<ClienteDTO> listaCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return ClienteDTO.converter(cliente);
    }

    public void cadsatrarCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return ClienteDTO.converter(cliente);
    }

}
