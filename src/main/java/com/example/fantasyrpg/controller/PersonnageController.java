package com.example.fantasyrpg.controller;

import com.example.fantasyrpg.model.Personnage;
import com.example.fantasyrpg.model.Caracteristique;
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
        model.addAttribute("caracteristique", new Caracteristique()); // Ajoute les caractéristiques au modèle
        model.addAttribute("dernierPersonnage", dernierPersonnage);
        return "personnages/create"; // Vue Thymeleaf
    }

    @PostMapping("/create")
    public String createPersonnage(@ModelAttribute Personnage personnage,
                                   @ModelAttribute Caracteristique caracteristique, // Récupère les caractéristiques depuis le formulaire
                                   Model model) {
        // Ici, vous pouvez éventuellement ajouter une logique pour sauvegarder les caractéristiques avec le personnage

        // Associer les caractéristiques au personnage
        personnage.setCaracteristique(caracteristique);

        // Sauvegarder le dernier personnage créé
        this.dernierPersonnage = personnage;
        return "redirect:/personnages/create"; // Redirige vers le formulaire de création
    }
}
