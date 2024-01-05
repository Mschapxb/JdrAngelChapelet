package com.example.Jdr.model.races;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.RaceModifier;

public class Nain implements RaceModifier {
    @Override
    public void applyModifiers(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        caracteristique.setConstitution(caracteristique.getConstitution() + 2);
        caracteristique.setForce_stat(caracteristique.getForce_stat() + 2);
    }
}
