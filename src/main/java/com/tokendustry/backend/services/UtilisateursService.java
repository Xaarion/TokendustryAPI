package com.tokendustry.backend.services;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.repositories.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    private HistoriqueDuPorteMonnaieService historiqueService;

    public List<Utilisateurs> findAll() {
        return utilisateursRepository.findAll();
    }

    public Optional<Utilisateurs> findById(int id) {
        return utilisateursRepository.findById(id);
    }

    public boolean userExist(String mail, String identifiant) {
        return utilisateursRepository.existsByMailOrIdentifiant(mail, identifiant);
    }

    public Utilisateurs save(Utilisateurs utilisateur) {
        Utilisateurs savedUser = utilisateursRepository.save(utilisateur);

        HistoriqueDuPorteMonnaie historique = new HistoriqueDuPorteMonnaie();
        historique.setUtilisateurs(savedUser);
        historique.setCredits(BigDecimal.valueOf(1000));
        historique.setDate(LocalDateTime.now());

        historiqueService.save(historique);

        return savedUser;
    }

    public void deleteById(int id) {
        utilisateursRepository.deleteById(id);
    }

    public Optional<Utilisateurs> connexion(String identif, String mdp) {
        return utilisateursRepository.findByIdentifiantAndPassword(identif, mdp);
    }
}
