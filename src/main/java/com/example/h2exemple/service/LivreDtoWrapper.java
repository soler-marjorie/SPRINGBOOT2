package com.example.h2exemple.service;

import com.example.h2exemple.dto.LivreDto;
import com.example.h2exemple.model.Livre;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LivreDtoWrapper {

    public LivreDto livreToDto(Livre livre) {
        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication().toString(),
                livre.getMaisonEdition(),
                livre.getUser().getEmail()
        );
    }
}
