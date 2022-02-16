package com.pani.contatti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pani.contatti.model.Contatto;
import com.pani.contatti.service.ContattoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:4200", allowedHeaders = "*" )
public class ContattiRestController {
	@Autowired
	private ContattoService contattoService;
	
	@GetMapping("/contatti")
	public List<Contatto> getContatti(){
		return contattoService.getAll();
	}
	
	@GetMapping("/contatto/{id}")
	public Contatto getContatto(@PathVariable String id) {
		return contattoService.findContatto(id).get();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteContatto(@PathVariable String id) {
		 contattoService.deleteContatto(id);
	}
	
	@PostMapping("/save")
	public void saveContatto(@RequestBody Contatto contatto) {
		 contattoService.saveContatto(contatto);
	}
	
	@PutMapping("/update")
	public void updateContatto(@RequestBody Contatto contatto) {
		 contattoService.saveContatto(contatto);
		 Contatto c =  contattoService.getByUsername(contatto.getUsername()).get(0);
		 System.out.println(c);
	}
	
}
