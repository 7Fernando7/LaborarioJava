package org.laboratoriojava.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.laboratoriojava.LoginRequest;
import org.laboratoriojava.entity.UserEntity;

public class LoginService {

    private final EntityManager em;

    public LoginService(EntityManager em) {
        this.em = em;
    }

    public LoginResult login(LoginRequest request) {

        try {
            UserEntity user = em.createQuery(
                            "SELECT u FROM UserEntity u WHERE u.email = :email",
                            UserEntity.class
                    )
                    .setParameter("email", request.getEmail())
                    .getSingleResult();

            if (!user.getPassword().equals(request.getPassword())) {
                return LoginResult.error("Credenciales incorrectas");
            }

            return LoginResult.ok();

        } catch (NoResultException e) {
            return LoginResult.error("Usuario no encontrado");
        }
    }
}
