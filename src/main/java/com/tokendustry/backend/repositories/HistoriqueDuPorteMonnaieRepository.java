package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueDuPorteMonnaieRepository extends JpaRepository<HistoriqueDuPorteMonnaie, Integer> {
    List<HistoriqueDuPorteMonnaie> findByUtilisateur(Utilisateurs utilisateur);
}
