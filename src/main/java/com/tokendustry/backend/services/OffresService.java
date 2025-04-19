package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Offres;
import com.tokendustry.backend.repositories.OffresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffresService {

    @Autowired
    private OffresRepository offresRepository;

    public List<Offres> findAll() {
        return offresRepository.findAll();
    }

    public Optional<Offres> findById(int id) {
        return offresRepository.findById(id);
    }

    public Offres save(Offres offre) {
        return offresRepository.save(offre);
    }

    public void deleteById(int id) {
        offresRepository.deleteById(id);
    }
}
