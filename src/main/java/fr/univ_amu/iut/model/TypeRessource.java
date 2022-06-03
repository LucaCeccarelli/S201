package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TYPE_RESSOURCE")
@NamedQueries({
        @NamedQuery(name = "TypeRessource.findAll", query = "SELECT p FROM TypeRessource p"),
        @NamedQuery(name = "TypeRessource.getById", query = "SELECT p FROM TypeRessource p WHERE p.id = :id"),
        @NamedQuery(name = "TypeRessource.findByNom", query = "SELECT p FROM TypeRessource p WHERE p.nom = :nom")
})
public class TypeRessource {
    @Id
    @GeneratedValue
    @Column(name = "ID_TYPE_RES")
    int id;
    @Column(name = "NOM_TYPE_RES")
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

    public String toString(){
        return nom;
    }
}
