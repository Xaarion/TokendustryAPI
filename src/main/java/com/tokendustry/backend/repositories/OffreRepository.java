package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Offre;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.model.Cryptomonnaie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
    List<Offre> findByUtilisateur(Utilisateurs utilisateur);
    List<Offre> findByCryptomonnaie(Cryptomonnaie cryptomonnaie);
}
