package ma.enset.examen.Dao;

import ma.enset.examen.Dao.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public List<Client> findAll() {
        Connection connection=SingletonConnexionDB.getConnaction();
        List<Client> clients =new ArrayList<>();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from CLIENT");
        ResultSet rs=stm.executeQuery();
        while(rs.next()){
            Client c=new Client();
            c.setId(rs.getInt("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setCin(rs.getString("CIN"));
            c.setTelephone(rs.getString("TELEPHONE"));
            c.setEmail(rs.getString("EMAIL"));
            c.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
            clients.add(c);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return clients;
    }


    @Override
    public Client findByID(double id){
        Connection connection=SingletonConnexionDB.getConnaction();
        Client c=new Client();
        try{
        PreparedStatement stm=connection.prepareStatement("select * from CLIENT where ID=?");
        stm.setDouble(1,id);
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            c.setId(rs.getInt("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setCin(rs.getString("CIN"));
            c.setTelephone(rs.getString("TELEPHONE"));
            c.setEmail(rs.getString("EMAIL"));
            c.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Client save(Client o){
                Connection connection=SingletonConnexionDB.getConnaction();
        try{
                PreparedStatement pstm=connection.prepareStatement("insert into CLIENT(NOM,PRENOM,CIN,TELEPHONE,EMAIL,DATE_NAISSANCE)"+" values(?,?,?,?,?,?,?)");
                pstm.setString(1,o.getNom());
                pstm.setString(2,o.getPrenom());
                pstm.setString(3,o.getCin());
                pstm.setString(4,o.getTelephone());
                pstm.setString(5,o.getEmail());
                pstm.setDate(6, (Date) o.getDate_naissance());
                pstm.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
                return o;

        }

    @Override
    public boolean delete(Client o){
            Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("delete from CLIENT where ID=?");
            pstm.setDouble(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Client update(Client o){
                Connection connection=SingletonConnexionDB.getConnaction();
        try{
                PreparedStatement pstm=connection.prepareStatement("update CLIENT set NOM=?,PRENOM=?,CIN=?,TELEPHONE=?,EMAIL=?,DATE_NAISSANCE=? where ID=?");
                pstm.setString(1,o.getNom());
                pstm.setString(2,o.getPrenom());
                pstm.setString(3,o.getCin());
                pstm.setString(4,o.getTelephone());
                pstm.setString(5,o.getEmail());
                pstm.setDate(6, (Date) o.getDate_naissance());
                pstm.setDouble(7,o.getId());
                pstm.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
                return o;

        }

    @Override
    public List<Client> findProduitByMc(String mc){
                Connection connection=SingletonConnexionDB.getConnaction();
                List<Client> clients =new ArrayList<>();
                try{
                PreparedStatement pstm=connection.prepareStatement("select * from Client where NOM like ?");
                pstm.setString(1,"%"+mc+"%");
                ResultSet rs=pstm.executeQuery();
                while(rs.next()){
                    Client c=new Client();
                    c.setId(rs.getInt("ID"));
                    c.setNom(rs.getString("NOM"));
                    c.setPrenom(rs.getString("PRENOM"));
                    c.setCin(rs.getString("CIN"));
                    c.setTelephone(rs.getString("TELEPHONE"));
                    c.setEmail(rs.getString("EMAIL"));
                    c.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                    clients.add(c);
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return clients;

        }


}
