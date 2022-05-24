package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TypeRessource {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeRessource(String nom) {
        this.nom = nom;
    }

    public TypeRessource() {}

    public String getNom() {
        return nom;
    }
}
