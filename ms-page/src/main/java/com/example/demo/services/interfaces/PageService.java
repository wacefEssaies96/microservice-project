package com.example.demo.services.interfaces;

import java.util.List;


import com.example.demo.persistance.entities.Page;

public interface PageService {
	public List<Page> afficherPages();
	public  Page ajouterPage(Page p);
	public  Page modifierPage(int id,Page p);
	public String supprimerPage(int id);
	public Page chercherPage(int id);

}
