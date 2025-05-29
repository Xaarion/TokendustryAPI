package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Cryptomonnaies;
import com.tokendustry.backend.model.Offres;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.repositories.CryptomonnaiesRepository;
import com.tokendustry.backend.repositories.OffresRepository;
import com.tokendustry.backend.repositories.UtilisateursRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OffresService {

    @Autowired
    private OffresRepository offresRepository;

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    private CryptomonnaiesRepository cryptomonnaiesRepository;

    public List<Offres> findAll() {
        return offresRepository.findAll();
    }

    public Optional<Offres> findById(int id) {
        return offresRepository.findById(id);
    }

  public Offres save(Offres offre) {
    // On récupère les vraies entités depuis leur ID
    Utilisateurs user = utilisateursRepository.findById(offre.getUtilisateur().getId())
                            .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    Cryptomonnaies crypto = cryptomonnaiesRepository.findById(offre.getCryptomonnaie().getId())
                            .orElseThrow(() -> new RuntimeException("Cryptomonnaie introuvable"));

    offre.setUtilisateur(user);
    offre.setCryptomonnaie(crypto);
    offre.setDateDeCreation(LocalDateTime.now());

    return offresRepository.save(offre);
}


    public void deleteById(int id) {
        offresRepository.deleteById(id);
    }
}
