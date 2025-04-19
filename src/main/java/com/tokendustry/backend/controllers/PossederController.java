package com.tokendustry.backend.controllers;

import com.tokendustry.backend.model.Posseder;
import com.tokendustry.backend.services.PossederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posseder")
public class PossederController {

    @Autowired
    private PossederService possederService;

    @GetMapping
    public List<Posseder> getAll() {
        return possederService.findAll();
    }

    @PostMapping
    public Posseder create(@RequestBody Posseder posseder) {
        return possederService.save(posseder);
    }
}
