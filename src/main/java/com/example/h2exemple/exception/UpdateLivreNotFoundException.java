package com.example.h2exemple.exception;

public class UpdateLivreNotFoundException extends RuntimeException {
    public UpdateLivreNotFoundException(Integer id) {
        super("le livre : " + id + " n'existe pas");
    }
}
