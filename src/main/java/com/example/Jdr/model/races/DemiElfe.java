package com.example.Jdr.model.races;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.RaceModifier;

public class DemiElfe implements RaceModifier {
    @Override
    public void applyModifiers(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        caracteristique.setCharisme(caracteristique.getCharisme() + 1);
        caracteristique.setSagesse(caracteristique.getSagesse() + 1);
    }
}
