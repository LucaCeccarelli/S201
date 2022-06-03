package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
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

    @OneToMany(cascade = CascadeType.ALL)
    List<Academie> academies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Ressource> ressources = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_USAGE")
    List<Acteur> acteurs = new ArrayList<>();

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

    public List<Academie> getAcademies() {
        return academies;
    }

    public void addAcademies(Academie ... academies) {
        this.academies.addAll(List.of(academies));
    }
    public void addAcademies(Collection<? extends Academie> academies){
        this.academies.addAll(academies);
    }

    public List<Ressource> getRessources() {
        return ressources;
    }

    public void addRessource(Ressource ressource) {
        this.ressources.add(ressource);
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void addActeur(Acteur acteur) {
        this.acteurs.add(acteur);
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
