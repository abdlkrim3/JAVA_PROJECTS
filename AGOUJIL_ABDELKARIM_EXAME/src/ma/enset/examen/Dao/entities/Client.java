package ma.enset.examen.Dao.entities;

import java.io.Serializable;
import java.util.Date;

//classe persistante ou entité
public class Client implements Serializable {
    private double id;
    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private String email;
    private Compte comptes;
    private java.sql.Date date_naissance;
    public Client() {
    }

    public Client(String nom, String prenom, String cin, String telephone, String email, Date date_naissance,Compte comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = (java.sql.Date) date_naissance;
        this.comptes=comptes;
    }

    public Compte getCompte() {
       return comptes;
    }

    public double getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = (java.sql.Date) date_naissance;
    }

    public Compte getComptes() {
        return comptes;
    }

    public void setComptes(Compte comptes) {
        this.comptes = comptes;
    }
}
