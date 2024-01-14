package ma.enset.examen.Presentation;

import ma.enset.examen.Dao.ClientDaoImpl;
import ma.enset.examen.Dao.entities.Client;
import ma.enset.examen.Service.CatalogueService;
import ma.enset.examen.Service.CatalogueServiceImpl;

import java.util.List;

public class ApplicationConsole {
    public static void main(String[] args) {
        CatalogueService pService=new CatalogueServiceImpl(new ClientDaoImpl());
        List<Client> clients = pService.getClientByMc("A");
        for (Client p : clients){
            System.out.println(p.getId()+" "+p.getNom()+" "+p.getPrenom()+" "+p.getCin()+" "+p.getTelephone());
        }
    }
}
