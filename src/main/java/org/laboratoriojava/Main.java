package org.example;

public class Main {

    public static void main(String[] args) {

        String password1 = "Hola1234";
        String password2 = "hola";
        String password3 = "Password1";

        System.out.println("Password 1 válida: " + PasswordValidator.isValid(password1));
        System.out.println("Password 2 válida: " + PasswordValidator.isValid(password2));
        System.out.println("Password 3 válida: " + PasswordValidator.isValid(password3));
    }
}