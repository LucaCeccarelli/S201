package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USAGE")
@NamedQueries({
        @NamedQuery(name = "Usage.findAll", query = "SELECT p FROM Usage p"),
        @NamedQuery(name = "Usage.getById", query = "SELECT p FROM Usage p WHERE p.id = :id"),
        @NamedQuery(name = "Usage.findByNom", query = "SELECT p FROM Usage p WHERE p.nom = :nom"),
        @NamedQuery(name = "Usage.findByDiscipline", query = "SELECT p FROM Usage p WHERE p.discipline = :discipline"),
        @NamedQuery(name = "Usage.findByThematique", query = "SELECT p FROM Usage p WHERE p.thematique = :thematique"),
        @NamedQuery(name = "Usage.findByNiveau", query = "SELECT p FROM Usage p WHERE p.niveau = :niveau"),
        @NamedQuery(name = "Usage.findByAcademie", query = "SELECT p FROM Usage p WHERE p.academie = :academie")
})

public class Usage {
    @Id
    @GeneratedValue
    @Column(name = "ID_USAGE")
    int id;

    @Column(name = "NOM_USAGE")
    String nom;
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DISC")
    Discipline discipline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_THEMA")
    Thematique thematique;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "CODE_ACA")
    Academie academie;

    @ManyToOne
    @JoinColumn(name = "ID_RES")
    Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "ID_ACT")
    Acteur acteur;

    public Usage() {
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

}
