package com.example.fantasyrpg.model;

public enum ProfilType {

    GUERRIER("Guerrier", 10),
    MAGICIEN("Magicien", 6),
    PRETRE("Prêtre", 8),
    RODEUR("Rôdeur", 8),
    VOLEUR("Voleur", 6);

    private final String nom;
    private final int hitPoints;

    ProfilType(String nom, int hitPoints) {
        this.nom = nom;
        this.hitPoints = hitPoints;
    }

    public String getNom() {
        return nom;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return nom;
    }
}