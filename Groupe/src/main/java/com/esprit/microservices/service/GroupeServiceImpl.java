package com.esprit.microservices.service;

import com.esprit.microservices.entities.Groupe;
import com.esprit.microservices.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository groupeRepository;

    @Autowired
    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    @Override
    public Groupe createGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public Groupe getGroupeById(int id) {
        return groupeRepository.findById(id).orElse(null);
    }

    @Override
    public Groupe updateGroupe(int id, Groupe updatedGroupe) {
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

    @Override
    public void deleteGroupe(int id) {
        groupeRepository.deleteById(id);
    }
}
