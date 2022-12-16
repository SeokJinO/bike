package com.example.bike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class BikeApplication {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args) {
        SpringApplication.run(BikeApplication.class, args);
    }

}
