package ma.enset.examen.Service;

import ma.enset.examen.Dao.entities.Compte;
import ma.enset.examen.Dao.entities.Client;

import java.util.List;

public interface CatalogueService {
    void addClient(Client p);
    void deletClient(Client p);
    List<Client> getALL();
    List<Client> getClientByMc(String mc);
    void updateClient(Client p);
    List<Compte> getAllCategory();
    Compte addCategory(Compte c);
}
