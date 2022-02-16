package com.pani.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATTO")
public class Contatto implements Serializable {
	private static final long serialVersionUID = 3328492997927690949L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome", nullable = true)
	private String nome;
	@Column(name = "cognome", nullable = true)
	private String cognome;
	@Column(name = "username", nullable = true, unique = true)
	private String username;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
