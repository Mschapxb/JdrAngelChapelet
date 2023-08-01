package com.example.fantasyrpg.model;

public enum ProfilType {

    GUERRIER("Guerrier", 10, false),
    MAGICIEN("Magicien", 4, true),
    PRETRE("Prêtre", 8, true),
    RODEUR("Rôdeur", 8, false),
    VOLEUR("Voleur", 6, false);

    private final String nom;
    private final int pointsVieParNiveau;
    private final boolean utiliseMagie;

    ProfilType(String nom, int pointsVieParNiveau, boolean utiliseMagie) {
        this.nom = nom;
        this.pointsVieParNiveau = pointsVieParNiveau;
        this.utiliseMagie = utiliseMagie;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsVieParNiveau() {
        return pointsVieParNiveau;
    }

    public boolean utiliseMagie() {
        return utiliseMagie;
    }

    @Override
    public String toString() {
        return nom;
    }
}