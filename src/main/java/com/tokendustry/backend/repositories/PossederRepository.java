package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Posseder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface PossederRepository extends JpaRepository<Posseder, Posseder.PossederId> {
    List<Posseder> findByIdUtilisateurs(int idUtilisateurs);

    // Rechercher une quantité pour un utilisateur et une cryptomonnaie donnée
    Optional<Posseder> findByIdUtilisateursAndId(int idUtilisateurs, int id);

    // Ou si tu veux être plus spécifique avec l'entité Cryptomonnaie
    Optional<Posseder> findByIdUtilisateursAndIdCryptomonnaies(int idUtilisateurs, int idCryptomonnaies);
}
