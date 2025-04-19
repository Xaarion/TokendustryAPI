package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Cryptomonnaies;
import com.tokendustry.backend.services.CryptomonnaiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cryptos")
public class CryptomonnaiesController {

    @Autowired
    private CryptomonnaiesService cryptomonnaiesService;

    @GetMapping
    public List<Cryptomonnaies> getAll() {
        return cryptomonnaiesService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cryptomonnaies> getById(@PathVariable int id) {
        return cryptomonnaiesService.findById(id);
    }

    @PostMapping
    public Cryptomonnaies create(@RequestBody Cryptomonnaies crypto) {
        return cryptomonnaiesService.save(crypto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cryptomonnaiesService.deleteById(id);
    }
}
