package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.services.HistoriqueDuPorteMonnaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiques")
public class HistoriqueDuPortemonnaieController {

    @Autowired
    private HistoriqueDuPorteMonnaieService historiqueDuPorteMonnaieService;

    @GetMapping
    public List<HistoriqueDuPorteMonnaie> getAll() {
        return historiqueDuPorteMonnaieService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<HistoriqueDuPorteMonnaie> getById(@PathVariable int id) {
        return historiqueDuPorteMonnaieService.findById(id);
    }

    @PostMapping
    public HistoriqueDuPorteMonnaie create(@RequestBody HistoriqueDuPorteMonnaie historique) {
        return historiqueDuPorteMonnaieService.save(historique);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        historiqueDuPorteMonnaieService.deleteById(id);
    }
}
