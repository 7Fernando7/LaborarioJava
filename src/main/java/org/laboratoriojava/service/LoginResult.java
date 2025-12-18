package org.laboratoriojava.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResult {

    private boolean success;
    private String message;

    public static LoginResult ok() {
        return new LoginResult(true, "Login correcto");
    }

    public static LoginResult error(String message) {
        return new LoginResult(false, message);
    }
}
