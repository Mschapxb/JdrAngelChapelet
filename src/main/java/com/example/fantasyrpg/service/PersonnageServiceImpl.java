package com.example.fantasyrpg.service;

import com.example.fantasyrpg.model.Personnage;
import com.example.fantasyrpg.repository.PersonnageRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonnageServiceImpl implements PersonnageService {

    private final PersonnageRepository personnageRepository;

    public PersonnageServiceImpl(PersonnageRepository personnageRepository) {
        this.personnageRepository = personnageRepository;
    }

    @Override
    public Personnage savePersonnage(Personnage personnage) {
        return personnageRepository.save(personnage);
    }
}
