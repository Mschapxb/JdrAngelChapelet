package com.example.Jdr.model;

public enum Race {

    HUMAIN("Humain"),
    ELFE("Elfe"),
    DEMI_ELFE("Demi-Elfe"),
    NAIN("Nain"),
    DEMI_ORQUE("Demi-Orque");

    private final String nom;

    Race(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }


    public void applyRaceModifiers(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        switch (this) {
            case HUMAIN:

                caracteristique.setForce_stat(caracteristique.getForce_stat() + 2);
                caracteristique.setDexterite(caracteristique.getDexterite() + 2);
                break;
            case ELFE:

                caracteristique.setIntelligence(caracteristique.getIntelligence() + 2);
                caracteristique.setSagesse(caracteristique.getSagesse() + 2);
                break;
            case DEMI_ELFE:

                caracteristique.setCharisme(caracteristique.getCharisme() + 1);
                caracteristique.setSagesse(caracteristique.getSagesse() + 1);
                break;
            case NAIN:

                caracteristique.setConstitution(caracteristique.getConstitution() + 2);
                caracteristique.setForce_stat(caracteristique.getForce_stat() + 2);
                break;
            case DEMI_ORQUE:

                caracteristique.setForce_stat(caracteristique.getForce_stat() + 2);
                caracteristique.setConstitution(caracteristique.getConstitution() + 2);
                break;
        }
    }
}