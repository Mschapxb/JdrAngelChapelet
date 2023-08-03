package com.example.Jdr.service;

import com.example.Jdr.model.Personnage;

import java.util.List;

public interface PersonnageService {
    Personnage savePersonnage(Personnage personnage);

    List<Personnage> getAllPersonnages();
    void deletePersonnage(Long id);

}
