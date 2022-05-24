package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.net.URL;

@Entity
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

    public URL getLienRessource() {
        return lienRessource;
    }
}
