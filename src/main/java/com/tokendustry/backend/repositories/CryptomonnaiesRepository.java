package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Cryptomonnaies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptomonnaiesRepository extends JpaRepository<Cryptomonnaies, Integer> {
    Cryptomonnaies findByLibelle(String libelle);
}
