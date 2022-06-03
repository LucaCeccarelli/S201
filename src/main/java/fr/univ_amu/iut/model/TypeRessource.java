package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "TypeRessource.findAll", query = "SELECT p FROM TypeRessource p"),
        @NamedQuery(name = "TypeRessource.getById", query = "SELECT p FROM TypeRessource p WHERE p.id = :id"),
        @NamedQuery(name = "TypeRessource.findByNom", query = "SELECT p FROM TypeRessource p WHERE p.nom = :nom")
})
public class TypeRessource {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeRessource(String nom) {
        this.nom = nom;
    }

    public TypeRessource() {}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
