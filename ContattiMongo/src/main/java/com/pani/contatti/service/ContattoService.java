package com.pani.contatti.service;

import java.util.List;
import java.util.Optional;

import com.pani.contatti.model.Contatto;

public interface ContattoService {

	void saveContatto(Contatto contatto);
	List<Contatto> getAll();
	Optional<Contatto> findContatto(String id);
	void deleteContatto(String id);
	

	List<Contatto> getByUsername(String username);
	List<Contatto> findByEtaBetween(int etaGT, int etaLT);
	List<Contatto> findByNomeStartingWith(String regex);
	List<Contatto> findByNomeEndingWith(String regex);
	long count();
	
	List<Contatto> findContattoByNome(String nome);
	List<Contatto> findContattoByRegex(String regex);
	List<Contatto> findContattoEtaBetween(int etaGT, int etaLT);
}


