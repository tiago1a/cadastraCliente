package com.cadastraCliente.cadastraCliente.repository;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import com.cadastraCliente.cadastraCliente.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    Endereco findByCep(String cep);
}
