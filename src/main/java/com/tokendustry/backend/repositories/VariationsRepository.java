package com.tokendustry.backend.repositories;

import com.tokendustry.backend.model.Variations;
import com.tokendustry.backend.model.Cryptomonnaies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VariationsRepository extends JpaRepository<Variations, Integer> {
    List<Variations> findByCryptomonnaie(Cryptomonnaies cryptomonnaie);
    List<Variations> findByCryptomonnaieAndDateAfter(Cryptomonnaies cryptomonnaie, LocalDateTime date);
}
