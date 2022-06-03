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
    @Column(name = "ID_RES")
    int id;
    @ManyToOne
    @JoinColumn(name = "ID_TYPE_RES")
    TypeRessource typeRessource;
    @Column(name = "LIEN_RES")
    String lienRessource;

    public Ressource(TypeRessource typeRessource, String lienRessource) {
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

    public String getLienRessource() {
        return lienRessource;
    }

    public String toString(){
        return lienRessource;
    }
}
