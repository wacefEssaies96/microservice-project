package com.example.demo.services.classes;

import java.util.List;


import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.entities.Page;
import com.example.demo.persistance.repositories.PageRepository;
import com.example.demo.services.interfaces.PageService;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	PageRepository pageRep;
	
	@Override
	public List<Page> afficherPages() {
		List<Page> l = this.pageRep.findAll();
		for(Page p : l) {
			System.out.println("Page : " + p.toString());
		}
		return l;
	}

	@Override
	public Page ajouterPage(Page p) {
		Page pp = null;
		try {
			pp = this.pageRep.save(p);
			System.out.println("Page a été ajouté avec succés !");
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		}
		return pp;
	}

	@Override
	public Page modifierPage(int id,Page p) {
		if (pageRep.findById(id).isPresent()) {
			Page existingPage= pageRep.findById(id).get();
			if(p.getNom() != null) {
				existingPage.setNom(p.getNom());
			}
			if(p.getDescription() != null) {
				existingPage.setDescription(p.getDescription());
			}
			if(p.getBadge() != null) {
				existingPage.setBadge(p.getBadge());
			}
			return pageRep.save(existingPage);
		} else
			return null;
	}

	@Override
	public String supprimerPage(int id) {
		if (pageRep.findById(id).isPresent()) {
			pageRep.deleteById(id);
			return "Page supprimé";
		} else
			return "Page non supprimé";
	}

	@Override
	public Page chercherPage(int id) {
		Page p = null ; 
		try {
			p = this.pageRep.findById(id).get();
			System.out.println(p.toString());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage()); 
		}
		return p;
	}

}
