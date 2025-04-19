package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Cryptomonnaies;
import com.tokendustry.backend.repositories.CryptomonnaiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptomonnaiesService {

    @Autowired
    private CryptomonnaiesRepository cryptomonnaieRepository;

    public List<Cryptomonnaies> findAll() {
        return cryptomonnaieRepository.findAll();
    }

    public Optional<Cryptomonnaies> findById(int id) {
        return cryptomonnaieRepository.findById(id);
    }

    public Cryptomonnaies save(Cryptomonnaies crypto) {
        return cryptomonnaieRepository.save(crypto);
    }

    public void deleteById(int id) {
        cryptomonnaieRepository.deleteById(id);
    }
}
