package com.pani.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pani.security.model.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
