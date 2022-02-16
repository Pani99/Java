package com.pani.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pani.security.repository.ContattoRepository;
import com.pani.security.service.ContattoService;

@Service("contattoService")
public class ContattoServiceImpl implements  ContattoService{
	@Autowired
	private ContattoRepository contattoRepository;

	@Override
	public List<com.pani.security.model.Contatto> getAll() {
	return (List<com.pani.security.model.Contatto>) contattoRepository.findAll();
	}

	
	
}
