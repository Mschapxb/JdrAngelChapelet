package com.example.Jdr.model.races;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.RaceModifier;

public class DemiOrque implements RaceModifier {
    @Override
    public void applyModifiers(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        caracteristique.setForce_stat(caracteristique.getForce_stat() + 2);
        caracteristique.setConstitution(caracteristique.getConstitution() + 2);
    }
}
