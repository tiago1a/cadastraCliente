package com.cadastraCliente.cadastraCliente.repository;

import com.cadastraCliente.cadastraCliente.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
