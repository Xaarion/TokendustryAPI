package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Offres;
import com.tokendustry.backend.services.OffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offres")
public class OffresController {

    @Autowired
    private OffresService offresService;

    @GetMapping
    public List<Offres> getAll() {
        return offresService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Offres> getById(@PathVariable int id) {
        return offresService.findById(id);
    }

    @PostMapping
    public Offres create(@RequestBody Offres offre) {
        return offresService.save(offre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        offresService.deleteById(id);
    }
}
