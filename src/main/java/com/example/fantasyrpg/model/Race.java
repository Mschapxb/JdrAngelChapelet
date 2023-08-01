package com.example.fantasyrpg.model;

public enum Race {

    HUMAIN("Humain", 0, 0, 0, 0, 0, 0),
    ELFE("Elfe", -2, 2, 0, 0, 0, 0),
    DEMI_ELFE("Demi-Elfe", 0, 0, 0, 0, 0, 0),
    NAIN("Nain", 0, -2, 2, 0, 0, 0),
    DEMI_ORQUE("Demi-Orque", 2, 0, 0, -2, 0, -2);

    private final String nom;
    private final int modificateurForce;
    private final int modificateurDexterite;
    private final int modificateurConstitution;
    private final int modificateurIntelligence;
    private final int modificateurSagesse;
    private final int modificateurCharisme;

    Race(String nom, int modificateurForce, int modificateurDexterite,
         int modificateurConstitution, int modificateurIntelligence,
         int modificateurSagesse, int modificateurCharisme) {

        this.nom = nom;
        this.modificateurForce = modificateurForce;
        this.modificateurDexterite = modificateurDexterite;
        this.modificateurConstitution = modificateurConstitution;
        this.modificateurIntelligence = modificateurIntelligence;
        this.modificateurSagesse = modificateurSagesse;
        this.modificateurCharisme = modificateurCharisme;
    }

    public String getNom() {
        return nom;
    }

    public int getModificateurForce() {
        return modificateurForce;
    }

    public int getModificateurDexterite() {
        return modificateurDexterite;
    }

    public int getModificateurConstitution() {
        return modificateurConstitution;
    }

    public int getModificateurIntelligence() {
        return modificateurIntelligence;
    }

    public int getModificateurSagesse() {
        return modificateurSagesse;
    }

    public int getModificateurCharisme() {
        return modificateurCharisme;
    }

    @Override
    public String toString() {
        return nom;
    }
}