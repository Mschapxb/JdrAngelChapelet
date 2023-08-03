package com.example.Jdr.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Caracteristique {

    private int force_stat = 10;
    private int dexterite = 10;
    private int constitution = 10;
    private int intelligence = 10;
    private int sagesse = 10;
    private int charisme = 10;

    private int forceModifier;
    private int dexteriteModifier;
    private int constitutionModifier;
    private int intelligenceModifier;
    private int sagesseModifier;
    private int charismeModifier;

    private int ca;
    private int cac;
    private int cad;

    public Caracteristique() {
    }

    public int getForce_stat() {
        return force_stat;
    }

    public void setForce_stat(int force) {
        this.force_stat = force;
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

    public int getForceModifier() {
        return forceModifier;
    }

    public void setForceModifier(int forceModifier) {
        this.forceModifier = forceModifier;
    }

    public int getDexteriteModifier() {
        return dexteriteModifier;
    }

    public void setDexteriteModifier(int dexteriteModifier) {
        this.dexteriteModifier = dexteriteModifier;
    }

    public int getConstitutionModifier() {
        return constitutionModifier;
    }

    public void setConstitutionModifier(int constitutionModifier) {
        this.constitutionModifier = constitutionModifier;
    }

    public int getIntelligenceModifier() {
        return intelligenceModifier;
    }

    public void setIntelligenceModifier(int intelligenceModifier) {
        this.intelligenceModifier = intelligenceModifier;
    }

    public int getSagesseModifier() {
        return sagesseModifier;
    }

    public void setSagesseModifier(int sagesseModifier) {
        this.sagesseModifier = sagesseModifier;
    }

    public int getCharismeModifier() {
        return charismeModifier;
    }

    public void setCharismeModifier(int charismeModifier) {
        this.charismeModifier = charismeModifier;
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

    public int getTotalHitPoints(ProfilType profilType) {
        int hitPointsFromProfile = profilType.getHitPoints();
        int constitutionModifier = this.getConstitutionModifier();
        return hitPointsFromProfile + constitutionModifier;
    }

    @Override
    public String toString() {
        return "Caracteristique{" +
                "force=" + force_stat +
                ", dexterite=" + dexterite +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", sagesse=" + sagesse +
                ", charisme=" + charisme +
                ", forceModifier=" + forceModifier +
                ", dexteriteModifier=" + dexteriteModifier +
                ", constitutionModifier=" + constitutionModifier +
                ", intelligenceModifier=" + intelligenceModifier +
                ", sagesseModifier=" + sagesseModifier +
                ", charismeModifier=" + charismeModifier +
                ", ca=" + ca +
                ", cac=" + cac +
                ", cad=" + cad +
                '}';
    }
}
