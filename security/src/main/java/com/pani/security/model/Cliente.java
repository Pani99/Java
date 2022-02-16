package com.pani.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cliente")
@Data
public class Cliente implements Serializable {
	private static final long serialVersionUID = -623410241858354018L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="nome", nullable = true)
	private String nome; 
	@Column(name="cognome", nullable = false)
	private String cognome;
	@Column(name="username", nullable = false, unique = true)
	private String username;
}
