package com.example.Jdr.controller;

import com.example.Jdr.model.Personnage;
import com.example.Jdr.model.Caracteristique;
import com.example.Jdr.model.ProfilType;
import com.example.Jdr.model.Race;
import com.example.Jdr.service.PersonnageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {

    private final PersonnageService personnageService;

    private Personnage dernierPersonnage;

    public PersonnageController(PersonnageService personnageService) {
        this.personnageService = personnageService;
    }
    @GetMapping("/")
    public String accueil(Model model) {
        return "accueil";
    }

    @GetMapping("/create")
    public String createPersonnageForm(Model model) {
        model.addAttribute("personnage", new Personnage());
        return "personnages/create";
    }
    @GetMapping("/list")
    public String listPersonnages(Model model) {
        List<Personnage> personnages = personnageService.getAllPersonnages();
        model.addAttribute("personnages", personnages);
        return "personnages/list";
    }
    @GetMapping("/delete/{id}")
    public String deletePersonnage(@PathVariable Long id) {
        personnageService.deletePersonnage(id);
        return "redirect:/personnages/list";
    }


    @PostMapping("/create")
    public String createPersonnage(@ModelAttribute Personnage personnage, Model model) {
        Caracteristique caracteristique = personnage.getCaracteristiques();
        if (caracteristique != null) {

            int totalPoints = caracteristique.getForce_stat() + caracteristique.getDexterite() +
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


        Personnage savedPersonnage = personnageService.savePersonnage(personnage);

        this.dernierPersonnage = savedPersonnage;
        return "redirect:/personnages/create";
    }

    @ModelAttribute("dernierPersonnage")
    public Personnage getDernierPersonnage() {
        return dernierPersonnage;
    }
}
