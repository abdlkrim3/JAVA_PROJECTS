package ma.enset.projet.Dao.entities;

import java.io.Serializable;

//classe persistante ou entité
public class Intervenants implements Serializable {
    private int idI;
    private int idT;
    private int idR;

    public Intervenants() {
    }

    public Intervenants(int idI, int idT, int idR) {
        this.idI = idI;
        this.idT = idT;
        this.idR = idR;
    }

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }
}
