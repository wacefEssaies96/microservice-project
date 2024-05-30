package com.esprit.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservices.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

}
