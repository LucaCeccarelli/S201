package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.net.URL;

@Entity
@NamedQueries({
        @NamedQuery(name = "Ressource.findAll", query = "SELECT p FROM Ressource p"),
        @NamedQuery(name = "Ressource.getById", query = "SELECT p FROM Ressource p WHERE p.id = :id"),
        @NamedQuery(name = "Ressource.getByUrl", query = "SELECT p FROM Ressource p WHERe p.lienRessource = :lienRessource")
})
public class Ressource {
    @Id
    @GeneratedValue
    int id;
    @ManyToOne
    TypeRessource typeRessource;
    URL lienRessource;

    public Ressource(TypeRessource typeRessource, URL lienRessource) {
        this.typeRessource = typeRessource;
        this.lienRessource = lienRessource;
    }

    public Ressource() {

    }

    public TypeRessource getTypeRessource() {
        return typeRessource;
    }

    public int getId() {
        return id;
    }

    public URL getLienRessource() {
        return lienRessource;
    }
}
