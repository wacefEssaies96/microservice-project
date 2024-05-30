package com.example.demo.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.persistance.entities.Page;

public interface PageRepository extends JpaRepository<Page ,Integer>  {

}
