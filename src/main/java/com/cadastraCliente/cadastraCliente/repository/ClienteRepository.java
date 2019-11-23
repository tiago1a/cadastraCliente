package com.cadastraCliente.cadastraCliente.repository;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nomeCliente);
}
