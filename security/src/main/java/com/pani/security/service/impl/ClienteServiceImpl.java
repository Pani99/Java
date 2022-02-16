package com.pani.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pani.security.model.Cliente;
import com.pani.security.repository.ClienteRepository;
import com.pani.security.service.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getClienti() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public boolean deleteCliente(Long id) {
		clienteRepository.deleteById(id);
		return true;
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
