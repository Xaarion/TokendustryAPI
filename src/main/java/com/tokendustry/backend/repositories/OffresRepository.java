package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Offres;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.model.Cryptomonnaies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffresRepository extends JpaRepository<Offres, Integer> {
    List<Offres> findByUtilisateur(Utilisateurs utilisateur);
    List<Offres> findByCryptomonnaie(Cryptomonnaies cryptomonnaie);
}
