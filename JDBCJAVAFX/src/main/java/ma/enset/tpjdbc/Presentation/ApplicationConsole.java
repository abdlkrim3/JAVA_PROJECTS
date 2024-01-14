package ma.enset.tpjdbc.Presentation;

import ma.enset.tpjdbc.Dao.ProduitDaoImpl;
import ma.enset.tpjdbc.Dao.entities.Produit;
import ma.enset.tpjdbc.Service.ProduitService;
import ma.enset.tpjdbc.Service.ProduitServiceImpl;

import java.util.List;

public class ApplicationConsole {
    public static void main(String[] args) {
        ProduitService pService=new ProduitServiceImpl(new ProduitDaoImpl());
        List<Produit> produits= pService.getProduitParMc("A");
        for (Produit p : produits){
            System.out.println(p.getId()+" "+p.getNom()+" "+p.getDescription()+" "+p.getPrix()+" "+p.getQuantite());
        }
    }
}
