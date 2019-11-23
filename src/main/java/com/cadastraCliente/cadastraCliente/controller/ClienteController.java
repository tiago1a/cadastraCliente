package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.ClienteRepository;

import java.util.List;

@Controller
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/clientes")
    @ResponseBody
   public List<ClienteDTO> listaCliente(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDTO.converter(clientes);
    }

}
