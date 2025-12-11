package org.laboratoriojava;

public class RegisterValidator {

    public static boolean isValid(RegisterRequest request) {

        if (request == null) return false;

        if (request.getUsername() == null || request.getUsername().isBlank()) return false;

        if (request.getEmail() == null ||
                !request.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            return false;

        String password = request.getPassword();
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpper && hasDigit;
    }
}