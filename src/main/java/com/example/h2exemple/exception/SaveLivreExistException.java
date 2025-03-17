package com.example.h2exemple.exception;

import com.example.h2exemple.model.Livre;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException(Livre livre) {
        super("Le livre : " + livre.getTitre() + ", " + livre.getDescription() + " existe déjà");
    }
}
