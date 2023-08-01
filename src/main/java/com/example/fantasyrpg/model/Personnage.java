package com.example.fantasyrpg.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personnages")
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "caracteristique_id")
    private Caracteristique caracteristiques;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Enumerated(EnumType.STRING)
    private ProfilType profilType;

    private int niveau = 1;

    public Personnage() {}

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

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getDefense() {
        return 10 + this.caracteristiques.getModificateurDexterite();
    }

    public int getAttaqueMelee() {
        return this.caracteristiques.getModificateurForce() + 1;
    }

    public int getAttaqueDistance() {
        return this.caracteristiques.getModificateurDexterite() + 1;
    }

    public int getPointsDeVie() {
        switch (profilType) {
            case GUERRIER:
                return 10;
            case MAGICIEN:
                return 4;
            case PRETRE:
                return 8;
            case RODEUR:
                return 8;
            case VOLEUR:
                return 6;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", caracteristiques=" + caracteristiques +
                ", race=" + race +
                ", profilType=" + profilType +
                ", niveau=" + niveau +
                '}';
    }

    public void setCaracteristique(Caracteristique caracteristique) {
    }
}
