package org.laboratoriojava;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResult {

    private boolean success;
    private String message;

    public static RegisterResult ok() {
        return new RegisterResult(true, "Usuario registrado correctamente");
    }

    public static RegisterResult error(String message) {
        return new RegisterResult(false, message);
    }
}
