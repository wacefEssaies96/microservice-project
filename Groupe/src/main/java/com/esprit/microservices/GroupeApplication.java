package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.microservices.entities.Groupe;
import com.esprit.microservices.repositories.GroupeRepository;

@SpringBootApplication
@EnableDiscoveryClient

@EnableEurekaClient
public class GroupeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupeApplication.class, args);
	}
	

    @Autowired
    private GroupeRepository repo;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // Correction : Utilisez la syntaxe de constructeur pour créer des objets Candidat
            repo.save(new Groupe("Groupe1", "description1", "règles1", "12-10-2022"));
            repo.save(new Groupe("Groupe2", "description2", "règles2", "12-11-2022"));
            repo.save(new Groupe("Groupe3", "description3", "règles3", "12-11-2023" ));
            repo.findAll().forEach(System.out::println);
        };
    }

}
