package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Acteur.findAll", query = "SELECT p FROM Acteur p"),
        @NamedQuery(name = "Acteur.findById", query = "SELECT p FROM Acteur p WHERE p.id = :id"),
})
@Entity
public class Acteur {
    @Id
    @GeneratedValue
    int id;

    String nom;
    String prenom;

    @Embedded
    Coordonees coordonees;

    @ManyToOne(cascade = CascadeType.ALL)
    TypeActeur typeActeur;

    public Acteur() {
        coordonees = new Coordonees();
        typeActeur = new TypeActeur();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Coordonees getCoordonees() {
        return coordonees;
    }

    public String getTypeActeur() {
        return typeActeur.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTypeActeur(String typeActeur) {
        this.typeActeur.setNom(typeActeur);
    }

    public int getNumero() {
        return coordonees.getNumero();
    }

    public void setNumero(int numero) {
        coordonees.setNumero(numero);
    }

    public String getRue() {
        return coordonees.getRue();
    }

    public void setRue(String rue) {
        coordonees.setRue(rue);
    }

    public String getCodePostal() {
        return coordonees.getCodePostal();
    }

    public void setCodePostal(String codePostal) {
        coordonees.setCodePostal(codePostal);
    }

    public String getVille() {
        return coordonees.getVille();
    }

    public void setVille(String ville) {
        coordonees.setVille(ville);
    }

    public String getMail() {
        return coordonees.getMail();
    }

    public void setMail(String mail) {
        coordonees.setMail(mail);
    }

    public String getTelephone() {
        return coordonees.getTelephone();
    }

    public void setTelephone(String telephone) {
        coordonees.setTelephone(telephone);
    }
}
