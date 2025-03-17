package com.example.h2exemple.repository;

import com.example.h2exemple.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
    Optional<Livre> findByTitreAndDescription(String titre, String description);
}
