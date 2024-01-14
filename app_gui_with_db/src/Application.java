
import ma.enset.app.dao.SingletonConnexionDB;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        // Charger le pilot JDPC pour MYSQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Établir la connexion avec la base de données
            Connection connection = SingletonConnexionDB.getConnection();
            Statement stm = connection.createStatement();
//            stm.executeUpdate("insert into  PRODUITS(NOM, DESCREPTION, PRIX, QUANTITE)" +
//                    "values ('DELL', 'Descreption 2', 54000, 5)");
            ResultSet rs = stm.executeQuery("SELECT * FROM PRODUITS");
            while(rs.next()){
                System.out.println("--------------------       Produit       -------------------");
                System.out.println("ID          : " + rs.getInt("ID"));
                System.out.println("NOM         : " + rs.getString("NOM"));
                System.out.println("DESCREPTION : " + rs.getString("DESCREPTION"));
                System.out.println("PRIX        : " + rs.getInt("PRIX"));
                System.out.println("QUANTITE    : " + rs.getInt("QUANTITE"));
                System.out.println("------------------------------------------------------------");
            }
            ResultSetMetaData rsmt = rs.getMetaData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
