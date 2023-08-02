package com.example.fantasyrpg.controller;

import com.example.fantasyrpg.model.Personnage;
import com.example.fantasyrpg.model.Caracteristique;
import com.example.fantasyrpg.model.ProfilType;
import com.example.fantasyrpg.model.Race;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {

    private Personnage dernierPersonnage;

    @GetMapping("/create")
    public String createPersonnageForm(Model model) {
        model.addAttribute("personnage", new Personnage());
        return "personnages/create";
    }

    @PostMapping("/create")
    public String createPersonnage(@ModelAttribute Personnage personnage, Model model) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        if (caracteristique != null) {

            int totalPoints = caracteristique.getForce() + caracteristique.getDexterite() +
                    caracteristique.getConstitution() + caracteristique.getIntelligence() +
                    caracteristique.getSagesse() + caracteristique.getCharisme();
            if (totalPoints != 75) {
                model.addAttribute("error", "Le total des points de caractéristiques doit être égal à 15.");
                return "personnages/create";
            }
        }


        Race selectedRace = personnage.getRace();


        selectedRace.applyRaceModifiers(personnage);


        personnage.calculateStatModifiers();

        ProfilType selectedProfilType = personnage.getProfilType();
        int totalHitPoints = personnage.getCaracteristiques().getTotalHitPoints(selectedProfilType);
        personnage.setTotalHitPoints(totalHitPoints);

        this.dernierPersonnage = personnage;
        return "redirect:/personnages/create";
    }

    @ModelAttribute("dernierPersonnage")
    public Personnage getDernierPersonnage() {
        return dernierPersonnage;
    }
}
