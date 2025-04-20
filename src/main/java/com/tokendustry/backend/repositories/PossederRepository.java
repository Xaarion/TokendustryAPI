package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Posseder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface PossederRepository extends JpaRepository<Posseder, Posseder.PossederId> {

    // Trouver tous les enregistrements d’un utilisateur
    List<Posseder> findByIdUtilisateurs(int idUtilisateurs);

    // Trouver une crypto spécifique possédée par un utilisateur
    Optional<Posseder> findByIdUtilisateursAndId(int idUtilisateurs, int id);
}
