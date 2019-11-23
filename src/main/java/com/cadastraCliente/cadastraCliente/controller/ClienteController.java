package com.cadastraCliente.cadastraCliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    @RequestMapping("/clientes")
    @ResponseBody
    public String lista(){
//        Cliente cliente = new Cliente("nome");
        String cliente = "tiago";
        return cliente; //ClienteDTO.converte(Arrays.asList()) ;
    }

}
