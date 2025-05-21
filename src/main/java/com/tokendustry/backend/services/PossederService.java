package com.tokendustry.backend.services;

import com.tokendustry.backend.model.Posseder;
import com.tokendustry.backend.model.Posseder.PossederId;
import com.tokendustry.backend.repositories.PossederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PossederService {

    @Autowired
    private PossederRepository possederRepository;

    @Autowired
    private CryptomonnaiesService cryptomonnaieService;

    public List<Posseder> findAll() {
        return possederRepository.findAll();
    }
    
    public Optional<Posseder> findById(PossederId id) {
        return possederRepository.findById(id);
    }

    public Optional<Posseder> getCryptoUser(int userId, int cryptoId) {
        return Optional.of(
            possederRepository.findByIdUtilisateursAndId(userId, cryptoId)
                .orElseGet(() -> {
                    Posseder p = new Posseder();
                    p.setId(cryptoId);
                    p.setIdUtilisateurs(userId);
                    p.setQuantite(BigDecimal.ZERO);
                    return p;
                })
        );
    }
    
   public List<Map<String, Object>> getAllCryptoUser(int id) {
    List<Posseder> possessions = possederRepository.findByIdUtilisateurs(id);
    List<Map<String, Object>> result = new ArrayList<>();

    for (Posseder p : possessions) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", p.getId());
        data.put("quantite", p.getQuantite());

        cryptomonnaieService.findById(p.getId()).ifPresentOrElse(
            crypto -> data.put("libelle", crypto.getLibelle()),
            () -> data.put("libelle", "Inconnu") // fallback
        );

        result.add(data);
    }

    return result;
}

    public Posseder save(Posseder posseder) {
        return possederRepository.save(posseder);
    }

    public void deleteById(PossederId id) {
        possederRepository.deleteById(id);
    }

    public Posseder soustraireQuantite(int userId, int cryptoId, double quantiteASoustraire) {
        Optional<Posseder> possOpt = getCryptoUser(userId, cryptoId);
    
        if (possOpt.isEmpty()) {
            throw new RuntimeException("Crypto non trouvée pour cet utilisateur");
        }
    
        Posseder p = possOpt.get();
        BigDecimal nouvelleQuantite = p.getQuantite().subtract(BigDecimal.valueOf(quantiteASoustraire));
    
        if (nouvelleQuantite.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Quantité insuffisante pour la soustraction");
        }
    
        p.setQuantite(nouvelleQuantite);
        return possederRepository.save(p);
    }
}
