package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Variations;
import com.tokendustry.backend.model.Cryptomonnaies;
import com.tokendustry.backend.repositories.VariationsRepository;
import com.tokendustry.backend.repositories.CryptomonnaiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariationsService {

    @Autowired
    private VariationsRepository variationRepository;

    @Autowired
    private CryptomonnaiesRepository cryptomonnaiesRepository;

    public List<Variations> findAll() {
        return variationRepository.findAll();
    }

    public Optional<Variations> findById(int id) {
        return variationRepository.findById(id);
    }

    public Optional<Variations> findLatestByCryptoId(int cryptoId) {
        return variationRepository.findTopByCryptomonnaieIdOrderByDateDesc(cryptoId);
    }

    public Variations save(Variations variation) {
        return variationRepository.save(variation);
    }

    public void deleteById(int id) {
        variationRepository.deleteById(id);
    }
}
