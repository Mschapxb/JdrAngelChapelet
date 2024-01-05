package com.example.Jdr.model.races;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.RaceModifier;

public class Elfe implements RaceModifier {
    @Override
    public void applyModifiers(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        caracteristique.setIntelligence(caracteristique.getIntelligence() + 2);
        caracteristique.setSagesse(caracteristique.getSagesse() + 2);
    }
}
