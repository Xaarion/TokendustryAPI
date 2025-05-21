package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Posseder;
import com.tokendustry.backend.services.PossederService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posseder")
public class PossederController {
    
    @Autowired
    private PossederService possederService;

    @GetMapping
    public List<Posseder> getAll() {
        return possederService.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Map<String, Object>> getCryptosPossedeesParUtilisateur(@PathVariable int id) {
        return possederService.getAllCryptoUser(id);
    }
    @GetMapping("/user/{userId}/crypto/{cryptoId}")
    public Optional<Posseder> getCryptoUser(@PathVariable int userId,@PathVariable int cryptoId) {
    return possederService.getCryptoUser(userId, cryptoId);
}
    @PostMapping
    public Posseder create(@RequestBody Posseder posseder) {
        return possederService.save(posseder);
    }

    @PutMapping("/soustraire")
public Posseder soustraireQuantite(@RequestBody Map<String, Object> payload) {
    int userId = (int) payload.get("id");
    int cryptoId = (int) payload.get("idCrypto");
    double quantite = Double.parseDouble(payload.get("quantite").toString());

    return possederService.soustraireQuantite(userId, cryptoId, quantite);
}
}
