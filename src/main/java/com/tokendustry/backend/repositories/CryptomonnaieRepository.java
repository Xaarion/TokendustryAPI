package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Cryptomonnaie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptomonnaieRepository extends JpaRepository<Cryptomonnaie, Integer> {
    Cryptomonnaie findByLibelle(String libelle);
}
