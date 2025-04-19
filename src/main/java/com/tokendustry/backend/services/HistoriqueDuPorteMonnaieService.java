package com.tokendustry.backend.services;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.repositories.HistoriqueDuPorteMonnaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueDuPorteMonnaieService {

    @Autowired
    private HistoriqueDuPorteMonnaieRepository historiqueRepository;

    public List<HistoriqueDuPorteMonnaie> findAll() {
        return historiqueRepository.findAll();
    }

    public Optional<HistoriqueDuPorteMonnaie> findById(int id) {
        return historiqueRepository.findById(id);
    }

    public HistoriqueDuPorteMonnaie save(HistoriqueDuPorteMonnaie historique) {
        return historiqueRepository.save(historique);
    }

    public void deleteById(int id) {
        historiqueRepository.deleteById(id);
    }
}
