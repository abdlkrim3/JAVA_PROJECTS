package ma.enset.projet.Dao.entities;

import java.io.Serializable;
import java.sql.Time;

//classe persistante ou entité
public class Ressources implements Serializable {
    private int idR;
    private String nom;
    private Time heuresDeTravail;

    public Ressources() {
    }

    public Ressources(int idR, String nom, Time heuresDeTravail) {
        this.idR = idR;
        this.nom = nom;
        this.heuresDeTravail = heuresDeTravail;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Time getHeuresDeTravail() {
        return heuresDeTravail;
    }

    public void setHeuresDeTravail(Time heuresDeTravail) {
        this.heuresDeTravail = heuresDeTravail;
    }
}
