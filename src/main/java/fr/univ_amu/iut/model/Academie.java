package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashMap;

@Entity
@Table(name = "ACADEMIE")
@NamedQueries({
        @NamedQuery(name = "Academie.findAll", query = "SELECT p FROM Academie p"),
        @NamedQuery(name = "Academie.getById", query = "SELECT p FROM Academie p WHERE p.code = :code"),
        @NamedQuery(name = "Academie.findByNom", query = "SELECT p FROM Academie p WHERE p.nom = :nom")
})

public class Academie {
    private final static HashMap<String, Academie> INSTANCES = new HashMap<>();
    @Transient
    public static Academie Mayotte = new Academie("MY", "Académie de Mayotte", RegionAcademique.Mayotte);
    @Transient
    public static Academie Besancon = new Academie("BE", "Académie de Besançon", RegionAcademique.BourgogneFrancheComte);
    @Transient
    public static Academie Bordeaux = new Academie("BO", "Académie de Bordeaux", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie ClermontFerrand = new Academie("CL", "Académie de Clermont-Ferrand", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Dijon = new Academie("DI", "Académie de Dijon", RegionAcademique.BourgogneFrancheComte);
    @Transient
    public static Academie Grenoble = new Academie("GR", "Académie de Grenoble", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Guadeloupe = new Academie("GU", "Académie de la Guadeloupe", RegionAcademique.Guadeloupe);
    @Transient
    public static Academie Guyane = new Academie("GA", "Académie de la Guyane", RegionAcademique.Guyane);
    @Transient
    public static Academie Martinique = new Academie("MA", "Académie de la Martinique", RegionAcademique.Martinique);
    @Transient
    public static Academie Reunion = new Academie("RE", "Académie de La Réunion", RegionAcademique.Reunion);
    @Transient
    public static Academie Limoges = new Academie("LI", "Académie de Limoges", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie Lyon = new Academie("LY", "Académie de Lyon", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Poitiers = new Academie("PO", "Académie de Poitiers", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie AixMarseille = new Academie("AI", "Académie d'Aix-Marseille", RegionAcademique.ProvenceAlpesCoteDAzur);
    @Transient
    public static Academie Amiens = new Academie("AM", "Académie d'Amiens", RegionAcademique.HautsDeFrance);
    @Transient
    public static Academie OrleansTours = new Academie("OR", "Académie d'Orléans-Tours", RegionAcademique.CentreValDeLoire);
    @Transient
    public static Academie Corse = new Academie("CO", "Académie de Corse", RegionAcademique.Corse);
    @Transient
    public static Academie Lille = new Academie("LL", "Académie de Lille", RegionAcademique.HautsDeFrance);
    @Transient
    public static Academie NancyMetz = new Academie("NM", "Académie de Nancy-Metz", RegionAcademique.GrandEst);
    @Transient
    public static Academie Nantes = new Academie("NA", "Académie de Nantes", RegionAcademique.PaysDeLaLoire);
    @Transient
    public static Academie Nice = new Academie("NI", "Académie de Nice", RegionAcademique.ProvenceAlpesCoteDAzur);
    @Transient
    public static Academie Normandie = new Academie("NO", "Académie de Normandie", RegionAcademique.Normandie);
    @Transient
    public static Academie Reims = new Academie("RI", "Académie de Reims", RegionAcademique.GrandEst);
    @Transient
    public static Academie Rennes = new Academie("RN", "Académie de Rennes", RegionAcademique.Bretagne);
    @Transient
    public static Academie Strasbourg = new Academie("ST", "Académie de Strasbourg", RegionAcademique.GrandEst);
    @Transient
    public static Academie Creteil = new Academie("CR", "Académie de Créteil", RegionAcademique.IleDeFrance);
    @Transient
    public static Academie Montpellier = new Academie("MO", "Académie de Montpellier", RegionAcademique.Occitanie);
    @Transient
    public static Academie Paris = new Academie("PA", "Académie de Paris", RegionAcademique.IleDeFrance);
    @Transient
    public static Academie Toulouse = new Academie("TO", "Académie de Toulouse", RegionAcademique.Occitanie);
    @Transient
    public static Academie Versailles = new Academie("VE", "Académie de Versailles", RegionAcademique.IleDeFrance);
    @Id
    String code;
    String nom;

    @ManyToOne(cascade = CascadeType.ALL)
    RegionAcademique regionAcademique;

    private Academie(String code, String nom, RegionAcademique regionAcademique) {
        this.code = code;
        this.nom = nom;
        this.regionAcademique = regionAcademique;
        INSTANCES.put(this.code, this);
    }

    public Academie() {
    }

    public static Academie get(String code) {
        return INSTANCES.get(code);
    }

    public static Collection<Academie> toutes() {
        return INSTANCES.values();
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public RegionAcademique getRegionAcademique() {
        return regionAcademique;
    }
}