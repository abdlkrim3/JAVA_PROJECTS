package ma.enset.projet.Dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

//classe persistante ou entité
public class Taches implements Serializable {
    private int idT;
    private int idP;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private Time dureeEstimee;
    private String etat;

    public Taches() {
    }

    public Taches(int idT, String nom, Date dateDebut, Date dateFin, Time dureeEstimee, String etat,int idP) {
        this.idT = idT;
        this.idP = idP;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dureeEstimee = dureeEstimee;
        this.etat = etat;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
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

    public Time getDureeEstimee() {
        return dureeEstimee;
    }

    public void setDureeEstimee(Time dureeEstimee) {
        this.dureeEstimee = dureeEstimee;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }
}
