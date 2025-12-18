package org.laboratoriojava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.laboratoriojava.service.LoginResult;
import org.laboratoriojava.service.LoginService;
import org.laboratoriojava.service.RegisterService;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Crear el EntityManagerFactory (UNA sola vez)
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("laboratorioPU");

        // 2️⃣ Crear el EntityManager
        EntityManager em = emf.createEntityManager();

        // 3️⃣ Servicios
        RegisterService registerService = new RegisterService(em);
        LoginService loginService = new LoginService(em);

        // 4️⃣ Registro
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("fernando")
                .email("fernando@email.com")
                .password("Password1")
                .build();

        RegisterResult registerResult =
                registerService.register(registerRequest);

        System.out.println(
                "REGISTER -> SUCCESS: " + registerResult.isSuccess() +
                        " | MESSAGE: " + registerResult.getMessage()
        );

        // 5️⃣ Login
        LoginRequest loginRequest = LoginRequest.builder()
                .email("fernando@email.com")
                .password("Password1")
                .build();

        LoginResult loginResult =
                loginService.login(loginRequest);

        System.out.println(
                "LOGIN -> SUCCESS: " + loginResult.isSuccess() +
                        " | MESSAGE: " + loginResult.getMessage()
        );

        // 6️⃣ Cerrar recursos
        em.close();
        emf.close();
    }
}
