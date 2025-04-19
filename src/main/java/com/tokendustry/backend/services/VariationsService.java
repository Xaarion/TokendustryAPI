package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Variation;
import com.tokendustry.backend.repositories.VariationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariationsService {

    @Autowired
    private VariationsRepository variationRepository;

    public List<Variation> findAll() {
        return variationRepository.findAll();
    }

    public Optional<Variation> findById(int id) {
        return variationRepository.findById(id);
    }

    public Variation save(Variation variation) {
        return variationRepository.save(variation);
    }

    public void deleteById(int id) {
        variationRepository.deleteById(id);
    }
}
