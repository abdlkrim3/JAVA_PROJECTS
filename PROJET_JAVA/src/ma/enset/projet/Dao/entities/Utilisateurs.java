package ma.enset.projet.Dao.entities;

import java.io.Serializable;

//classe persistante ou entité
public class Utilisateurs implements Serializable {
    private int idU;
    private String nom;
    private String prenom;
    private String motDePasse;
    private String role;

    public Utilisateurs() {
    }

    public Utilisateurs(int id, String nom, String prenom, String motDePasse, String role) {
        this.idU = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public int getId() {
        return idU;
    }

    public void setId(int id) {
        this.idU = id;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
