package ma.enset.examen.Dao;

import ma.enset.examen.Dao.entities.Client;

import java.sql.SQLException;
import java.util.List;

public class DaoTest {
    public static void main(String[] args) throws SQLException {
        ClientDao pDao=new ClientDaoImpl();
        Client p1=new Client();
/*
        p2.setNom("MAC");
        p2.setDescription("description 2");
        p2.setPrix(20000);
        p2.setQuantite(4);
        pDao.save(p2);
          */
        Client p2=pDao.findByID(2);
        p2.setPrix(22000);
        p2.setQuantite(9);
        pDao.update(p2);
        List<Client> clients =pDao.findAll();
        for (Client p: clients) {
            System.out.println(p.getId()+" "+p.getNom()+" "+p.getDescription()+" "+p.getPrix()+" "+p.getQuantite());
        }
    }
}
