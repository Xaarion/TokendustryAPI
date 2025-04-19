package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.repositories.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    public List<Utilisateurs> findAll() {
        return utilisateursRepository.findAll();
    }

    public Optional<Utilisateurs> findById(int id) {
        return utilisateursRepository.findById(id);
    }

    public Utilisateurs save(Utilisateurs utilisateur) {
        return utilisateursRepository.save(utilisateur);
    }

    public void deleteById(int id) {
        utilisateursRepository.deleteById(id);
    }
}
