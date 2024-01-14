package ma.enset.examen.Dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Compte implements Serializable {
    private double id;
    private String num_compte;
    private Date date_creation;
    private float solde;
    private boolean bloque;
    List<Client> clients =new ArrayList<>();
    public Compte() {
    }
    public void addClient(Client client){
        clients.add(client);
    }

    public Compte(double id, String num_compte, Date date_creation, float solde, boolean bloque, List<Client> clients) {
        this.id = id;
        this.num_compte = num_compte;
        this.date_creation = date_creation;
        this.solde = solde;
        this.bloque = bloque;
        this.clients = clients;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
