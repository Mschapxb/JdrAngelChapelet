package com.example.Jdr.service;

import com.example.Jdr.model.Personnage;
import com.example.Jdr.repository.PersonnageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Personnage> getAllPersonnages() {
        return personnageRepository.findAll();
    }

    @Override
    public void deletePersonnage(Long id) {
        personnageRepository.deleteById(id);
    }
}
