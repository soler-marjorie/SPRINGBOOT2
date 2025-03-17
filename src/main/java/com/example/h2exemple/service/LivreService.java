package com.adrar.cdah2.service;

import com.adrar.cdah2.dto.LivreDto;
import com.adrar.cdah2.exception.NoLivreFoundException;
import com.adrar.cdah2.exception.SaveLivreExistException;
import com.adrar.cdah2.exception.UpdateLivreNotFoundException;
import com.adrar.cdah2.model.Livre;
import com.adrar.cdah2.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private LivreDtoWrapper livreDtoWrapper;

    //Méthode qui retourne tous les objets Livre
    public Iterable<Livre> getAll(){
        if(livreRepository.count() == 0) {
            throw new NoLivreFoundException();
        }
        return livreRepository.findAll();
    }

    public Long countLivre() {
        return livreRepository.count();
    }

    //Méthode qui retourne un Livre par son id
    public Optional<Livre> getById(int id){
        return livreRepository.findById(id);
    }
    //Méthode qui ajoute un Livre
    public Livre add(Livre livre){
        if(livreRepository.findByTitreAndDescription(livre.getTitre(), livre.getDescription()).isPresent()) {
            throw  new SaveLivreExistException(livre);
        }
        return livreRepository.save(livre);
    }

    //Méthode qui supprime un Livre par son id
    public boolean remove(int id) {
        if(!livreRepository.existsById(id)) {
            return false;
        }
        livreRepository.deleteById(id);
        return true;
    }

    //Méthode qui met à jour un Livre
    public Livre update(Livre livre, int id){
        if(!livreRepository.existsById(id)) {
            throw new UpdateLivreNotFoundException(id);
        }
        livre.setId(id);
        return livreRepository.save(livre);
    }


    //méthode qui retourne un livre par son Id en LivreDto
    public LivreDto getLivreDtoById(int id) {
        if(!livreRepository.existsById(id)) {
            throw new UpdateLivreNotFoundException(id);
        }
        return livreDtoWrapper.livreToDto(livreRepository.findById(id).get());
    }

    public List<LivreDto> getAllLivreDto() {
        if(livreRepository.count() == 0) {
            throw new NoLivreFoundException();
        }
        List<LivreDto> livresDto =  new ArrayList<>();
        for (Livre livre : livreRepository.findAll()) {
            livresDto.add(livreDtoWrapper.livreToDto(livre));
        }
        return livresDto;
    }
}
