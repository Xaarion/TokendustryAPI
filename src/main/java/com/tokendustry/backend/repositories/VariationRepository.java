package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Variation;
import com.tokendustry.backend.model.Cryptomonnaie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VariationRepository extends JpaRepository<Variation, Integer> {
    List<Variation> findByCryptomonnaie(Cryptomonnaie cryptomonnaie);
    List<Variation> findByCryptomonnaieAndDateAfter(Cryptomonnaie cryptomonnaie, LocalDateTime date);
}
