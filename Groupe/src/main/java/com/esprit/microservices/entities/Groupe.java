package com.esprit.microservices.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public class Groupe implements Serializable {
@Id 
@GeneratedValue
private int id;
private String nom,description, règles;
private String dateDecreation;
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
public String getRègles() {
	return règles;
}
public void setRègles(String règles) {
	this.règles = règles;
}
public String getDateDecreation() {
	return dateDecreation;
}
public void setDateDecreation(String dateDecreation) {
	this.dateDecreation = dateDecreation;
}
public Groupe() {
	super();
	// TODO Auto-generated constructor stub
}
public Groupe( String nom, String description, String règles, String dateDecreation) {
	super();
	this.nom = nom;
	this.description = description;
	this.règles = règles;
	this.dateDecreation = dateDecreation;
}



}
