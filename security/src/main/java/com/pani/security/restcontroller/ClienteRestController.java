package com.pani.security.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pani.security.model.Cliente;
import com.pani.security.service.ClienteService;


@RestController
@RequestMapping("/api")
public class ClienteRestController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clienti")
	public List<Cliente> getClienti(){
		return clienteService.getClienti();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getUtente(@PathVariable Long id){
		return clienteService.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteUtente(@PathVariable Long id){
		return clienteService.deleteCliente(id);
	}
	
	@PostMapping("/save")
	public Cliente saveCliente(@RequestBody Cliente cliente){
		return clienteService.saveCliente(cliente);
	}
	
	@PutMapping("/update")
	public Cliente updateCliente(@RequestBody Cliente cliente){
		return clienteService.saveCliente(cliente);
	}	
}
