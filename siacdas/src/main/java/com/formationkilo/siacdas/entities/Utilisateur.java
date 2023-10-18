package com.formationkilo.siacdas.entities;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Utilisateur implements UserDetails{

	/**
	 * @author Bonevy
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="mot_de_passe")
	private String motDePasse;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="email")
	private String email;
	
	private boolean actif=false;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Role role;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getLibelle()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.motDePasse;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.actif;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.actif;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.actif;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.actif;
	}
// ACCESSEURS ET MUTATEURS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	// constructeurs avec et sans Ar.
	public Utilisateur() {
		super();
	}

	public Utilisateur(int id, String motDePasse, String nom, String email, boolean actif, Role role) {
		super();
		this.id = id;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}
	
	
	

	
	
}
