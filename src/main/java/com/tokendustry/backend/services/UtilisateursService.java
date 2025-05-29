package com.tokendustry.backend.services;

import com.tokendustry.backend.model.HistoriqueDuPorteMonnaie;
import com.tokendustry.backend.model.Utilisateurs;
import com.tokendustry.backend.repositories.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    private HistoriqueDuPorteMonnaieService historiqueService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Utilisateurs> findAll() {
        return utilisateursRepository.findAll();
    }

    public Optional<Utilisateurs> findById(int id) {
        return utilisateursRepository.findById(id);
    }

  public Optional<String> getPseudoById(int id) {
      return utilisateursRepository.findById(id)
            .map(Utilisateurs::getPseudonyme);
}

    

    public boolean userExist(String mail, String identifiant) {
        return utilisateursRepository.existsByMailOrIdentifiant(mail, identifiant);
    }

    public Optional<Utilisateurs> connexion(String identif, String mdp) {
        Optional<Utilisateurs> userOpt = utilisateursRepository.findByIdentifiant(identif);
    
        if (userOpt.isPresent()) {
            Utilisateurs user = userOpt.get();
            if (passwordEncoder.matches(mdp, user.getPassword())) {
                return Optional.of(user);
            }
        }
    
        return Optional.empty();
    }

    public Utilisateurs save(Utilisateurs utilisateur) {
 
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
    
        utilisateur.setAcces(1);

        Utilisateurs savedUser = utilisateursRepository.save(utilisateur);
    
        HistoriqueDuPorteMonnaie historique = new HistoriqueDuPorteMonnaie();
        historique.setUtilisateurs(savedUser);
        historique.setCredits(BigDecimal.valueOf(1000));
        historique.setDate(LocalDateTime.now());
    
        historiqueService.save(historique);
    
        return savedUser;
    }

    public void deleteById(int id) {
        utilisateursRepository.deleteById(id);
    }

   
}
