package com.tokendustry.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historiqueduportemonnaie")
public class HistoriqueDuPorteMonnaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 20, scale = 5)
    private java.math.BigDecimal credits;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_Utilisateurs", nullable = false)
    private Utilisateurs utilisateur;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public java.math.BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(java.math.BigDecimal credits) {
        this.credits = credits;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateur;
    }

    public void setUtilisateurs(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }
}
