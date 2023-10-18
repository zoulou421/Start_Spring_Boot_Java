package com.formationkilo.siacdas.entities;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Validation {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Instant creation;
	private Instant expire;
	private Instant activation;
	private String code;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Utilisateur utilisateur;

	public Validation() {
	
	}

	public Validation(int id, Instant creation, Instant expire, Instant activation, String code,
			Utilisateur utilisateur) {
		this.id = id;
		this.creation = creation;
		this.expire = expire;
		this.activation = activation;
		this.code = code;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getCreation() {
		return creation;
	}

	public void setCreation(Instant creation) {
		this.creation = creation;
	}

	public Instant getExpire() {
		return expire;
	}

	public void setExpire(Instant expire) {
		this.expire = expire;
	}

	public Instant getActivation() {
		return activation;
	}

	public void setActivation(Instant activation) {
		this.activation = activation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
