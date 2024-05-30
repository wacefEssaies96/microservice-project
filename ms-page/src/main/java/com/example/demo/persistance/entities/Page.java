package com.example.demo.persistance.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Page implements Serializable {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	private String nom,description;
	private Boolean badge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getBadge() {
		return badge;
	}
	public void setBadge(Boolean badge) {
		this.badge = badge;
	}

	public Page(int id, String nom, String description, Boolean badge) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.badge = badge;
	}
	public Page() {
		super();
	}
	
	

	
}
