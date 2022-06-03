package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USAGE")
@NamedQueries({
        @NamedQuery(name = "Usage.findAll", query = "SELECT p FROM Usage p"),
        @NamedQuery(name = "Usage.findNom", query = "SELECT p FROM Usage p WHERE p.nom = :nom"),
        @NamedQuery(name = "Usage.getById", query = "SELECT p FROM Usage p WHERE p.id = :id")
})

public class Usage {
    @Id
    @GeneratedValue
    int id;

    String nom;
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    Discipline discipline;

    @ManyToOne(cascade = CascadeType.ALL)
    Thematique thematique;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToOne
    Academie academie;

    @ManyToOne
    Ressource ressource;

    @ManyToOne
    Acteur acteur;

    String commentaire;

    public Usage() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Thematique getThematique() {
        return thematique;
    }

    public void setThematique(Thematique thematique) {
        this.thematique = thematique;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Academie getAcademie() {
        return academie;
    }

    public void setAcademie(Academie academie){
        this.academie = academie;
    }
    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
