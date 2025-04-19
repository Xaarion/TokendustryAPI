package com.tokendustry.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "variations")
public class Variations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private BigDecimal valeur;

    @ManyToOne
    @JoinColumn(name = "id_Cryptomonnaies", nullable = false)
    private Cryptomonnaies cryptomonnaie;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    public Cryptomonnaies getCryptomonnaie() {
        return cryptomonnaie;
    }

    public void setCryptomonnaie(Cryptomonnaies cryptomonnaie) {
        this.cryptomonnaie = cryptomonnaie;
    }
}
