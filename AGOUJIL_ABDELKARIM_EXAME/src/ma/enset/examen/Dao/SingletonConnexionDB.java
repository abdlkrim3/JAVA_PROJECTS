package ma.enset.examen.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexionDB {
    private static Connection connexion;
    static{
        try {
            //charger le pilote GDBC pour mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //établir la connextion avec la basea de donnee
            connexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/EXAMEN","root","");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnaction(){
        return connexion;
    }
}
