package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Discipline.findAll", query = "SELECT p FROM Discipline p"),
        @NamedQuery(name = "Discipline.getById", query = "SELECT p FROM Discipline p WHERE p.id = :id"),
        @NamedQuery(name = "Discipline.findByNom", query = "SELECT p FROM Discipline p WHERE p.nom = :nom")
})
public class Discipline {
    @Transient
    public static Discipline Toutes = new Discipline("Toutes disciplines");
    @Transient
    public static Discipline HistoireGeographie = new Discipline("Histoire-géographie");
    @Transient
    public static Discipline PhysiqueChimie = new Discipline("Physique-chimie");
    @Transient
    public static Discipline ScienceEtVieDeLaTerre = new Discipline("SVT");
    @Transient
    public static Discipline Technologie = new Discipline("Technologie");
    @Transient
    public static Discipline Francais = new Discipline("Français");
    @Transient
    public static Discipline EconomieGestion = new Discipline("Économie Gestion");
    @Transient
    public static Discipline LangueVivante = new Discipline("Langue Vivante");

    @Id
    @GeneratedValue
    @Column(name = "ID_DISC")
    int id;
    @Column(name = "NOM_DISC")
    String nom;

    public Discipline() {

    }

    Discipline(String nom) {
        this.nom = nom;
    }

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
