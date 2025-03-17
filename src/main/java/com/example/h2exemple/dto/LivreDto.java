package com.example.h2exemple.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public record LivreDto(
        Integer id,
        String titre,
        String auteur,
        String datePublication,
        String maisonEdition,
        String email
) {

    public static LivreDto fromEntity(com.example.h2exemple.model.Livre livre) {
        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication(),
                livre.getMaisonEdition() != null ? livre.getMaisonEdition().getLibele() : null
        );
    }
}
