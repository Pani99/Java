package com.pani.contatti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pani.contatti.model.Contatto;
import com.pani.contatti.repository.ContattoRepository;
import com.pani.contatti.service.ContattoService;

/**
 * Devo avere OBBLIGATORIAMENTE la notation @service
 * 
 */

@Service("contattoService")
public class ContattoServiceImpl implements ContattoService {

	@Autowired
	private ContattoRepository contattoRepository; 			// crea un oggetto anonimo per fornire le funzionalità del repository

	@Override
	public void saveContatto(Contatto contatto) {
		contattoRepository.save(contatto);
	}

	@Override
	public List<Contatto> getAll() {
		return contattoRepository.findAll();
	}

	@Override
	public Optional<Contatto> findContatto(String id) {
		return contattoRepository.findById(id);
	}

	@Override
	public void deleteContatto(String id) {
		contattoRepository.deleteById(id);
	}

	@Override
	public List<Contatto> getByUsername(String username) {
		return contattoRepository.findByUsername(username);
	}

	@Override
	public List<Contatto> findByEtaBetween(int etaGT, int etaLT) {
		return contattoRepository.findByEtaBetween(etaGT, etaLT);
	}

	@Override
	public List<Contatto> findByNomeStartingWith(String regex) {
		return contattoRepository.findByNomeStartingWith(regex);
	}

	@Override
	public List<Contatto> findByNomeEndingWith(String regex) {
		return contattoRepository.findByNomeEndingWith(regex);
	}

	@Override
	public long count() {
		return contattoRepository.count();
	}

	@Override
	public List<Contatto> findContattoByNome(String nome) {
		return contattoRepository.findContattoByNome(nome);
	}

	@Override
	public List<Contatto> findContattoByRegex(String regex) {
		return contattoRepository.findContattoByRegex(regex);
	}

	@Override
	public List<Contatto> findContattoEtaBetween(int etaGT, int etaLT) {
		return contattoRepository.findContattoEtaBetween(etaGT, etaLT);
	}

}
