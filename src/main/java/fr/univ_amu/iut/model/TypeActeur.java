package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "TypeActeur.findAll", query = "SELECT p FROM TypeActeur p"),
        @NamedQuery(name = "TypeActeur.getById", query = "SELECT p FROM TypeActeur p WHERE p.id = :id"),
        @NamedQuery(name = "TypeActeur.findByNom", query = "SELECT p FROM TypeActeur p WHERE p.nom = :nom")
})
public class TypeActeur {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeActeur(String nom) {
        this.nom = nom;
    }

    public TypeActeur() {

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
