package com.example.Jdr.service;

import com.example.Jdr.model.Personnage;
import com.example.Jdr.repository.PersonnageRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonnageServiceImpl implements PersonnageService {

    private final PersonnageRepository personnageRepository;
    private final StatistiquesService statistiquesService;


    public PersonnageServiceImpl(PersonnageRepository personnageRepository, StatistiquesService statistiquesService) {
        this.personnageRepository = personnageRepository;
        this.statistiquesService = statistiquesService;
    }

    @Override
    public Personnage createAndSavePersonnage(Personnage personnage) {

        if (personnage.getRace() != null) {
            personnage.getRace().applyModifiers(personnage);
        }

        statistiquesService.calculerStatistiques(personnage);

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
