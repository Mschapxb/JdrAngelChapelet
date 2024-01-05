package com.example.Jdr.service;

import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.Personnage;
import org.springframework.stereotype.Service;

@Service
public class StatistiquesService {

    public void calculerStatistiques(Personnage personnage) {
        Caracteristique caracteristique = personnage.getCaracteristiques();

        if (caracteristique != null) {
            // Calcul des modificateurs en fonction des caractéristiques
            caracteristique.setForceModifier(calculerModificateur(caracteristique.getForce_stat()));
            caracteristique.setDexteriteModifier(calculerModificateur(caracteristique.getDexterite()));
            caracteristique.setConstitutionModifier(calculerModificateur(caracteristique.getConstitution()));
            caracteristique.setIntelligenceModifier(calculerModificateur(caracteristique.getIntelligence()));
            caracteristique.setSagesseModifier(calculerModificateur(caracteristique.getSagesse()));
            caracteristique.setCharismeModifier(calculerModificateur(caracteristique.getCharisme()));

            // Calcul de CA, CAC, et CAD
            int ca = 10 + caracteristique.getDexteriteModifier();
            int cac = 1 + caracteristique.getForceModifier();
            int cad = 1 + caracteristique.getDexteriteModifier();

            caracteristique.setCa(ca);
            caracteristique.setCac(cac);
            caracteristique.setCad(cad);

            // Calcul des points de vie totaux
            int totalHitPoints = calculerTotalHitPoints(personnage);
            personnage.setTotalHitPoints(totalHitPoints);
        }
    }

    private int calculerModificateur(int valeurCaracteristique) {
        return valeurCaracteristique / 2 - 5;
    }

    private int calculerTotalHitPoints(Personnage personnage) {
        int hitPointsFromProfile = personnage.getProfilType().getHitPoints();
        int constitutionModifier = personnage.getCaracteristiques().getConstitutionModifier();
        return hitPointsFromProfile + constitutionModifier;
    }
}
