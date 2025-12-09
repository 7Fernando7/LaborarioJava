package org.laboratoriojava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaBootstrap {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("laboratorioPU");

        EntityManager em = emf.createEntityManager();

        RegisterRequest user = RegisterRequest.builder()
                .username("fernando")
                .email("fernando@test.com")
                .password("Password123")
                .build();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
