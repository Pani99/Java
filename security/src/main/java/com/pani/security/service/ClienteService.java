package com.pani.security.service;

import java.util.List;

import com.pani.security.model.Cliente;

public interface ClienteService {
	List<Cliente>getClienti();
	Cliente findById(Long id);
	boolean deleteCliente(Long id);
	Cliente saveCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente);
}
