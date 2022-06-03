package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "TypeRessource.findAll", query = "SELECT p FROM TypeRessource p"),
        @NamedQuery(name = "TypeRessource.getById", query = "SELECT p FROM TypeRessource p WHERE p.id = :id"),
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

    public String getNom() {
        return nom;
    }
}
