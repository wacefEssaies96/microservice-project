package com.esprit.microservices.service;

import com.esprit.microservices.entities.Groupe;

import java.util.List;

public interface GroupeService {
	
	Groupe createGroupe(Groupe groupe);
    List<Groupe> getAllGroupes();
    Groupe getGroupeById(int id);
    Groupe updateGroupe(int id, Groupe updatedGroupe);
    void deleteGroupe(int id);

}
