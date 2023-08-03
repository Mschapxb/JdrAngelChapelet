package com.example.Jdr.service;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.ProfilType;
import com.example.Jdr.model.Race;
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
    public Personnage createAndSavePersonnage(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();

        if (caracteristique != null) {
            int totalPoints = caracteristique.getForce_stat() + caracteristique.getDexterite() +
                    caracteristique.getConstitution() + caracteristique.getIntelligence() +
                    caracteristique.getSagesse() + caracteristique.getCharisme();

            if (totalPoints != 75) {
                throw new IllegalArgumentException("Le total des points de caractéristiques doit être égal à 15.");
            }
        }

        Race selectedRace = personnage.getRace();
        selectedRace.applyRaceModifiers(personnage);

        personnage.calculateStatModifiers();

        ProfilType selectedProfilType = personnage.getProfilType();
        int totalHitPoints = personnage.getCaracteristiques().getTotalHitPoints(selectedProfilType);
        personnage.setTotalHitPoints(totalHitPoints);

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
