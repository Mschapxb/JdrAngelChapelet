package com.example.Jdr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personnages")
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Embedded
    private Caracteristique caracteristiques;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Enumerated(EnumType.STRING)
    private ProfilType profilType;

    private int totalHitPoints;



    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Caracteristique getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(Caracteristique caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public ProfilType getProfilType() {
        return profilType;
    }

    public void setProfilType(ProfilType profilType) {
        this.profilType = profilType;
    }

    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    public void setTotalHitPoints(int totalHitPoints) {
        this.totalHitPoints = totalHitPoints;
    }



    // La méthode toString reste inchangée
    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", race=" + race +
                ", profilType=" + profilType +
                ", totalHitPoints=" + totalHitPoints +
                '}';
    }
}
