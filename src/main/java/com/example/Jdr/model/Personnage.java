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

    @Column(insertable = false, updatable = false)
    private int ca;
    @Column(insertable = false, updatable = false)
    private int cac;
    @Column(insertable = false, updatable = false)
    private int cad;

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

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getCac() {
        return cac;
    }

    public void setCac(int cac) {
        this.cac = cac;
    }

    public int getCad() {
        return cad;
    }

    public void setCad(int cad) {
        this.cad = cad;
    }

    public void calculateStatModifiers() {
        Caracteristique caracteristique = this.getCaracteristiques();

        caracteristique.setForceModifier(caracteristique.getForce_stat() / 2 - 5);
        caracteristique.setDexteriteModifier(caracteristique.getDexterite() / 2 - 5);
        caracteristique.setConstitutionModifier(caracteristique.getConstitution() / 2 - 5);
        caracteristique.setIntelligenceModifier(caracteristique.getIntelligence() / 2 - 5);
        caracteristique.setSagesseModifier(caracteristique.getSagesse() / 2 - 5);
        caracteristique.setCharismeModifier(caracteristique.getCharisme() / 2 - 5);

        int ca = 10 + caracteristique.getDexteriteModifier();
        int cac = 1 + caracteristique.getForceModifier();
        int cad = 1 + caracteristique.getDexteriteModifier();

        caracteristique.setCa(ca);
        caracteristique.setCac(cac);
        caracteristique.setCad(cad);

        this.ca = ca;
        this.cac = cac;
        this.cad = cad;
    }

    public void applyAllModifiers() {
        calculateStatModifiers();
        if (race != null) {
            race.applyRaceModifiers(this);
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
                ", totalHitPoints=" + totalHitPoints +
                ", ca=" + ca +
                ", cac=" + cac +
                ", cad=" + cad +
                '}';
    }
}
