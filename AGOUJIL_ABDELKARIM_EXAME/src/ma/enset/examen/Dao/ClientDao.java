package ma.enset.examen.Dao;

import ma.enset.examen.Dao.entities.Client;

import java.util.List;

public interface ClientDao extends Dao<Client>{
    List<Client> findProduitByMc(String mc) ;
    List<Client> findAllClientByID(double id) ;


}
