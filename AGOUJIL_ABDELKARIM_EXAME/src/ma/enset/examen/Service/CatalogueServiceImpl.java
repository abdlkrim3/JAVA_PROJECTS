package ma.enset.examen.Service;

import ma.enset.examen.Dao.CompteDao;
import ma.enset.examen.Dao.ClientDao;
import ma.enset.examen.Dao.entities.Compte;
import ma.enset.examen.Dao.entities.Client;

import java.util.List;

public class CatalogueServiceImpl implements CatalogueService {
    private ClientDao clDao;

    private CompteDao coDao;
    public CatalogueServiceImpl(ClientDao pdao){
        this.clDao =pdao;
    }
    @Override
    public void addClient(Client p) {
        clDao.save(p);
    }

    @Override
    public void deletClient(Client p) {
        clDao.delete(p);

    }

    @Override
    public List<Client> getALL() {
        return clDao.findAll();
    }

    @Override
    public List<Client> getClientByMc(String mc) {
        return clDao.findProduitByMc(mc);
    }

    @Override
    public void updateClient(Client p) {
        clDao.update(p);
    }

    @Override
    public List<Compte> getAllCategory() {
        return null;
    }

    @Override
    public Compte addCategory(Compte c) {
        return null;
    }
}
