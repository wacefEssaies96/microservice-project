package tn.esprit.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsPublication2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsPublication2Application.class, args);
	}

}
