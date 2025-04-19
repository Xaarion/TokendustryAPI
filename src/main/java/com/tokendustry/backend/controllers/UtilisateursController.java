package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.services.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateursController {

    @Autowired
    private UtilisateursService utilisateursService;

    @GetMapping
    public List<Utilisateurs> getAll() {
        return utilisateursService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Utilisateurs> getById(@PathVariable int id) {
        return utilisateursService.findById(id);
    }

    @PostMapping
    public Utilisateurs create(@RequestBody Utilisateurs utilisateur) {
        return utilisateursService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        utilisateursService.deleteById(id);
    }
}
