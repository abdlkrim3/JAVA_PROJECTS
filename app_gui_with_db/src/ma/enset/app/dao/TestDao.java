package ma.enset.app.dao;

import ma.enset.app.dao.entities.Product;

import java.sql.SQLException;
import java.util.*;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        DaoProduct pDao = new DaoProductImpl();

//        Produit p1 = new Produit();
//        p1.setNom("HP");
//        p1.setQuantite(10);
//        p1.setPrix(15000);
//        //  testing save()
//        pDao.save(p1);

        //  testing findById() & update()
        Product p2 = pDao.findById(11);
        if(p2 != null){
            p2.setPrix(20000);
            p2.setQuantite(3);
            pDao.update(p2);
        }
        else{
            System.out.println("Produit n'existe pas dans la base de données");
        }
        //  testing findAll()
        List<Product> listProduit = pDao.findAll();
        for(Product p : listProduit){
            System.out.println("--------------------       Produit       -------------------");
            System.out.println("ID          : " + p.getId());
            System.out.println("NOM         : " + p.getNom());
            System.out.println("DESCREPTION : " + p.getDescreption());
            System.out.println("PRIX        : " + p.getPrix());
            System.out.println("QUANTITE    : " + p.getQuantite());
            System.out.println("------------------------------------------------------------");
        }
    }
}
