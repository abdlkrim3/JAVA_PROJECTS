package ma.enset.app.presentation;

import ma.enset.app.dao.DaoProductImpl;
import ma.enset.app.dao.entities.Product;
import ma.enset.app.services.ServiceProduct;
import ma.enset.app.services.ProduitServiceImpl;

import java.util.*;

public class ApplicationConsole {
    public static void main(String[] args) {
        ServiceProduct pService = new ProduitServiceImpl(new DaoProductImpl());
        List<Product> listProduit = pService.getProductByQuery("DELL");

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
