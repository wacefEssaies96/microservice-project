package com.esprit.microservices.controller;

import com.esprit.microservices.entities.Groupe;
import com.esprit.microservices.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")  // Le chemin de base pour toutes les opérations liées au groupe
public class GroupeController {

    private final GroupeRepository groupeRepository;

    @Autowired
    public GroupeController(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    // Endpoint pour créer un nouveau groupe
    @PostMapping
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    // Endpoint pour récupérer tous les groupes
    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    // Endpoint pour récupérer un groupe par son ID
    @GetMapping("/{id}")
    public Groupe getGroupeById(@PathVariable int id) {
        return groupeRepository.findById(id).orElse(null);
    }

    // Endpoint pour mettre à jour un groupe
    @PutMapping("/{id}")
    public Groupe updateGroupe(@PathVariable int id, @RequestBody Groupe updatedGroupe) {
        Groupe existingGroupe = groupeRepository.findById(id).orElse(null);
        if (existingGroupe != null) {
            existingGroupe.setNom(updatedGroupe.getNom());
            existingGroupe.setDescription(updatedGroupe.getDescription());
            existingGroupe.setRègles(updatedGroupe.getRègles());
            existingGroupe.setDateDecreation(updatedGroupe.getDateDecreation());
            return groupeRepository.save(existingGroupe);
        }
        return null;
    }

    // Endpoint pour supprimer un groupe par son ID
    @DeleteMapping("/{id}")
    public void deleteGroupe(@PathVariable int id) {
        groupeRepository.deleteById(id);
    }
}