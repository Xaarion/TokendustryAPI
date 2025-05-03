package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Posseder;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.services.PossederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Posseder> getAllCryptoUser(@PathVariable int id) {
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
}
