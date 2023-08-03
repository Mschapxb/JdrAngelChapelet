package com.example.Jdr.controller;

import com.example.Jdr.model.Personnage;
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
        try {
            Personnage savedPersonnage = personnageService.createAndSavePersonnage(personnage);
            this.dernierPersonnage = savedPersonnage;
            return "redirect:/personnages/create";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "personnages/create";
        }
    }

    @ModelAttribute("dernierPersonnage")
    public Personnage getDernierPersonnage() {
        return dernierPersonnage;
    }
}
