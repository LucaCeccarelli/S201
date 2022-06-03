package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TYPE_ACTEUR")
@NamedQueries({
        @NamedQuery(name = "TypeActeur.findAll", query = "SELECT p FROM TypeActeur p"),
        @NamedQuery(name = "TypeActeur.getById", query = "SELECT p FROM TypeActeur p WHERE p.id = :id"),
        @NamedQuery(name = "TypeActeur.findByNom", query = "SELECT p FROM TypeActeur p WHERE p.nom = :nom")
})
public class TypeActeur {
    @Id
    @GeneratedValue
    @Column(name = "ID_TYPE_ACT")
    int id;
    @Column(name = "NOM_TYPE_ACT")
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

    public String toString(){
        return nom;
    }
}
