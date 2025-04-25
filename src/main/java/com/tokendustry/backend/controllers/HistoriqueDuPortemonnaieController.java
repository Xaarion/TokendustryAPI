package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.services.HistoriqueDuPorteMonnaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historique")
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

    @GetMapping("/solde/{id}")
    public Optional<HistoriqueDuPorteMonnaie> getSoldeByUserId(@PathVariable int id) {
        return historiqueDuPorteMonnaieService.findSoldeByUserId(id);
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
