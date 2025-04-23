package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer> {
    Optional<Utilisateurs> findByMail(String mail);
    Optional<Utilisateurs> findByIdentifiant(String identifiant);
    Optional<Utilisateurs> findByIdentifiantAndPassword(String identifiant, String password);
}
