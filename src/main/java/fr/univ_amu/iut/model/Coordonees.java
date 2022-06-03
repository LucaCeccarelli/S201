package fr.univ_amu.iut.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Coordonees {
    @Column(name = "NUM_ACT")
    private int numero;
    @Column(name = "RUE_ACT")
    private String rue;
    @Column(name = "CP_ACT")
    private String codePostal;
    @Column(name = "VILLE_ACT")
    private String ville;
    @Column(name = "MAIL_ACT")
    private String mail;
    @Column(name = "TEL_ACT")
    private String telephone;

    public Coordonees() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}