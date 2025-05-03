package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Variations;
import com.tokendustry.backend.services.VariationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/variations")
public class VariationsController {

    @Autowired
    private VariationsService variationsService;

    @GetMapping
    public List<Variations> getAll() {
        return variationsService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Variations> getById(@PathVariable int id) {
        return variationsService.findById(id);
    }

    @GetMapping("/crypto/{id}")
    public Optional<Variations> getByCryptoId(@PathVariable int id) {
        return variationsService.findLatestByCryptoId(id);
    }
    
    @PostMapping
    public Variations create(@RequestBody Variations variation) {
        return variationsService.save(variation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        variationsService.deleteById(id);
    }
}
