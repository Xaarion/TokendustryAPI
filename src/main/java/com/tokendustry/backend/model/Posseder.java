package com.tokendustry.backend.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Posseder")
@IdClass(Posseder.PossederId.class)
public class Posseder {

    @Id
    private int id;

    @Id
    @Column(name = "id_Utilisateurs")
    private int idUtilisateurs;

    @Column(nullable = false, precision = 20, scale = 20)
    private BigDecimal quantite;

    // Clé composite
    public static class PossederId implements Serializable {
        private int id;
        private int idUtilisateurs;

        public PossederId() {}

        public PossederId(int id, int idUtilisateurs) {
            this.id = id;
            this.idUtilisateurs = idUtilisateurs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PossederId)) return false;
            PossederId that = (PossederId) o;
            return id == that.id && idUtilisateurs == that.idUtilisateurs;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, idUtilisateurs);
        }
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(int idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }
}
