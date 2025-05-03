package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Posseder;
import com.tokendustry.backend.model.Posseder.PossederId;
import com.tokendustry.backend.repositories.PossederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PossederService {

    @Autowired
    private PossederRepository possederRepository;

    public List<Posseder> findAll() {
        return possederRepository.findAll();
    }
    
    public Optional<Posseder> findById(PossederId id) {
        return possederRepository.findById(id);
    }

    public Optional<Posseder> getCryptoUser(int userId, int cryptoId) {
        return Optional.of(
            possederRepository.findByIdUtilisateursAndId(userId, cryptoId)
                .orElseGet(() -> {
                    Posseder p = new Posseder();
                    p.setId(cryptoId);
                    p.setIdUtilisateurs(userId);
                    p.setQuantite(BigDecimal.ZERO);
                    return p;
                })
        );
    }
    
    public List<Posseder> getAllCryptoUser(int id) {
        return possederRepository.findByIdUtilisateurs(id);
    }

    public Posseder save(Posseder posseder) {
        return possederRepository.save(posseder);
    }

    public void deleteById(PossederId id) {
        possederRepository.deleteById(id);
    }
}
