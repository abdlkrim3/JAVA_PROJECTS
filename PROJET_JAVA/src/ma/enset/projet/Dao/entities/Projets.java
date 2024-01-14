package ma.enset.projet.Dao.entities;

import java.io.Serializable;
import java.sql.Date;

//classe persistante ou entité
public class Projets implements Serializable {
    private int idP;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String etat;

    public Projets() {
    }

    public Projets(int idP, String nom, Date dateDebut, Date dateFin, String etat) {
        this.idP = idP;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
