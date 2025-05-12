package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.services.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/existe")
    public boolean utilisateurExiste(
        @RequestParam String mail,
        @RequestParam String identifiant
    ) {
        return utilisateursService.userExist(mail, identifiant);
    }

    @GetMapping("/connexion")
    public ResponseEntity<Utilisateurs> connecter(
            @RequestParam String identif,
            @RequestParam String mdp
    ) {
        return utilisateursService.connexion(identif, mdp)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateurs create(@RequestBody Utilisateurs utilisateur) {
        return utilisateursService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        utilisateursService.deleteById(id);
    }
}
