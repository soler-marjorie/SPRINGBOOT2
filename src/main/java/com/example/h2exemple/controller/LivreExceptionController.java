package com.example.h2exemple.controller;

import com.example.h2exemple.exception.LivreNotFoundException;
import com.example.h2exemple.exception.NoLivreFoundException;
import com.example.h2exemple.exception.SaveLivreExistException;
import com.example.h2exemple.exception.UpdateLivreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    public ResponseEntity<Map<String, String>> livreNotFound(LivreNotFoundException livreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", livreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoLivreFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noLivres(NoLivreFoundException noLivreFound) {
        return noLivreFound.getMessage();
    }


    @ExceptionHandler(UpdateLivreNotFoundException.class)
    public ResponseEntity<Map<String, String>> updateLivreNotFoundhandler(UpdateLivreNotFoundException updateLivreNotFoundException) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", updateLivreNotFoundException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveLivreExistException.class)
    public ResponseEntity<Map<String, String>> saveLivreExist(SaveLivreExistException saveLivreExistException) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", saveLivreExistException.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
}
