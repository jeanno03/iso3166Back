package org.sid.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="my_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String pseudo;
	String mdp;
	String email;
	String nom;
	String prenom;
	
	@OneToMany(mappedBy="user")
	private List<Iso3166>iso3166s; 
	
	public User() {
		super();
	}

	public User(String pseudo, String mdp, String email, String nom, String prenom) {
		super();
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", mdp=" + mdp + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	

}
