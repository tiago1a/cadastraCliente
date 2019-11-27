package com.cadastraCliente.cadastraCliente.repository;

import com.cadastraCliente.cadastraCliente.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
