package com.cadastraCliente.cadastraCliente.controller;
import com.cadastraCliente.cadastraCliente.controller.dto.ClienteDTO;
import com.cadastraCliente.cadastraCliente.controller.form.AtualizaClienteForm;
import com.cadastraCliente.cadastraCliente.controller.form.ClienteForm;
import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import com.cadastraCliente.cadastraCliente.modelo.Endereco;
import com.cadastraCliente.cadastraCliente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cadastraCliente.cadastraCliente.repository.ClienteRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteRepository clienteRepository;

    @CrossOrigin
    @GetMapping
   public List<ClienteDTO> listaCliente(String nomeCliente) {
        if(nomeCliente == null){
            List<Cliente> cliente = clienteRepository.findAll();
            return ClienteDTO.converter(cliente);
        }else {
            List<Cliente> cliente = clienteRepository.findByNome(nomeCliente);
            return ClienteDTO.converter(cliente);
        }
    }

    @CrossOrigin
    @Transactional
    @PostMapping
    public ResponseEntity<ClienteDTO> cadsatrarCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder){
        //converter form para cliente
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);

        //montando o retorno de sucesso
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        //retornar o 201 de sucesso
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ClienteDTO detalharCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getOne(id);
        return new ClienteDTO(cliente);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDTO> atualizaCliente(@PathVariable Long id, @RequestBody @Valid AtualizaClienteForm atualizaClienteForm ){
        Cliente cliente = atualizaClienteForm.atualiza(id, clienteRepository);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removerCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
