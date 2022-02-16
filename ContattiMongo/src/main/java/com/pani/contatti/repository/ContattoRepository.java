package com.pani.contatti.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pani.contatti.model.Contatto;

public interface ContattoRepository extends MongoRepository<Contatto, String> {
	
	List<Contatto> findByUsername(String username);
	List<Contatto> findByEtaBetween(int etaGT, int etaLT);
	List<Contatto> findByNomeStartingWith(String regex);
	List<Contatto> findByNomeEndingWith(String regex);
	long count();
	
	@Query("{'nome': ?0}")			// ?0 è la posizione del parametro
	List<Contatto> findContattoByNome(String nome);
	
	@Query("{'nome': {$regex: ?0}}")			
	List<Contatto> findContattoByRegex(String regex);
	
	@Query("{'eta': {$gt: ?0, $lt: ?1}}")			
	List<Contatto> findContattoEtaBetween(int etaGT, int etaLT);
}

