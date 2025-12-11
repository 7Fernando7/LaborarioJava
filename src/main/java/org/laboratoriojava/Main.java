package org.laboratoriojava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.laboratoriojava.service.RegisterService;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Arrancar JPA
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("laboratorioPU");
        EntityManager em = emf.createEntityManager();

        // 2️⃣ Crear el servicio
        RegisterService registerService = new RegisterService(em);

        // 3️⃣ Crear una request válida
        RegisterRequest request = RegisterRequest.builder()
                .username("fernanndo")
                .email("fernando@email.com")
                .password("Password1")
                .build();

        // 4️⃣ Ejecutar el registro
        RegisterResult result = registerService.register(request);

        // 5️⃣ Ver el resultado
        System.out.println(
                "SUCCESS: " + result.isSuccess() +
                        " | MESSAGE: " + result.getMessage()
        );

        // 6️⃣ Cerrar recursos
        em.close();
        emf.close();
    }
}
