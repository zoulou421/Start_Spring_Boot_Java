package com.formationkilo.siacdas.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.formationkilo.siacdas.enumeration.TypeDeRole;

@Entity
public class Role {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private TypeDeRole libelle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeDeRole getLibelle() {
		return libelle;
	}

	public void setLibelle(TypeDeRole libelle) {
		this.libelle = libelle;
	}

	public Role() {
		super();
	}

	public Role(int id, TypeDeRole libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
		
	
}
