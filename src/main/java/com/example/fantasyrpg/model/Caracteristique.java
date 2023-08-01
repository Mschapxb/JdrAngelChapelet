package com.example.fantasyrpg.model;

import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "caracteristiques")
public class Caracteristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int force = 10;
    private int dexterite = 10;
    private int constitution = 10;
    private int intelligence = 10;
    private int sagesse = 10;
    private int charisme = 10;

    private int pointsRestants = 15;

    public Caracteristique() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSagesse() {
        return sagesse;
    }

    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }

    public int getCharisme() {
        return charisme;
    }

    public void setCharisme(int charisme) {
        this.charisme = charisme;
    }

    public int getPointsRestants() {
        return pointsRestants;
    }

    public void setPointsRestants(int pointsRestants) {
        this.pointsRestants = pointsRestants;
    }

    public boolean isValid() {
        int totalPointsUsed =
                (force - 10) +
                        (dexterite - 10) +
                        (constitution - 10) +
                        (intelligence - 10) +
                        (sagesse - 10) +
                        (charisme - 10);
        return totalPointsUsed <= 15;
    }

    public int getModificateur(int value) {
        return (value / 2) - 5;
    }

    public int getModificateurForce() {
        return getModificateur(force);
    }

    public int getModificateurDexterite() {
        return getModificateur(dexterite);
    }

    // Si nécessaire, vous pouvez ajouter d'autres méthodes modificateurs pour chaque attribut

    @Override
    public String toString() {
        return "Caracteristique{" +
                "id=" + id +
                ", force=" + force +
                ", dexterite=" + dexterite +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", sagesse=" + sagesse +
                ", charisme=" + charisme +
                ", pointsRestants=" + pointsRestants +
                '}';
    }
}
