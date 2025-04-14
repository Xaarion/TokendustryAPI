package com.tokendustry.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Offres")
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int montant;

    @Column(nullable = false)
    private java.math.BigDecimal prix;

    @Column(nullable = false)
    private LocalDateTime dateDeCreation;

    @ManyToOne
    @JoinColumn(name = "id_Utilisateurss", nullable = false)
    private Utilisateurs utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_Cryptomonnaies", nullable = false)
    private Cryptomonnaie cryptomonnaie;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public java.math.BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(java.math.BigDecimal prix) {
        this.prix = prix;
    }

    public LocalDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateur;
    }

    public void setUtilisateurs(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Cryptomonnaie getCryptomonnaie() {
        return cryptomonnaie;
    }

    public void setCryptomonnaie(Cryptomonnaie cryptomonnaie) {
        this.cryptomonnaie = cryptomonnaie;
    }
}
