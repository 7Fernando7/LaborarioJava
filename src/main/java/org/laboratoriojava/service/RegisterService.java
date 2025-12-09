package org.laboratoriojava.service;

import jakarta.persistence.EntityManager;
import org.laboratoriojava.RegisterRequest;
import org.laboratoriojava.RegisterResult;
import org.laboratoriojava.RegisterValidator;

public class RegisterService {

    private final EntityManager em;

    public RegisterService(EntityManager em) {
        this.em = em;
    }

    public RegisterResult register(RegisterRequest request) {

        // 1. Validación
        if (!RegisterValidator.isValid(request)) {
            return RegisterResult.error("Violación de restricción de unicidad");

        }

        // 2. Normalización
        request.setEmail(request.getEmail().toLowerCase());
        request.setUsername(request.getUsername().trim());

        // 3. Persistencia
        try {
            em.getTransaction().begin();
            em.persist(request);
            em.getTransaction().commit();
            return RegisterResult.ok();

        } catch (Exception e) {
            em.getTransaction().rollback();
            return RegisterResult.error("El usuario o email ya existen");
        }
    }
}
