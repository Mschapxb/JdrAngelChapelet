package com.example.Jdr.model;

import com.example.Jdr.model.races.*;

public enum Race {
    HUMAIN("Humain", new Humain()),
    ELFE("Elfe", new Elfe()),
    DEMI_ELFE("Demi-Elfe", new DemiElfe()),
    NAIN("Nain", new Nain()),
    DEMI_ORQUE("Demi-Orque", new DemiOrque());

    private final String nom;
    private final RaceModifier modifier;

    Race(String nom, RaceModifier modifier) {
        this.nom = nom;
        this.modifier = modifier;
    }

    public String getNom() {
        return nom;
    }

    public void applyModifiers(Personnage personnage) {
        modifier.applyModifiers(personnage);
    }

    @Override
    public String toString() {
        return nom;
    }
}
