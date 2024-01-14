package ma.enset.examen.Dao;


import ma.enset.examen.Dao.entities.Compte;




public interface CompteDao extends Dao<Compte> {
    Compte bloquerCompte(Compte o);
    float retirer(float f);
    float verser(float f);
}
