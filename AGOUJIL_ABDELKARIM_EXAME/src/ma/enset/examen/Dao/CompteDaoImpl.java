package ma.enset.examen.Dao;

import ma.enset.examen.Dao.entities.Compte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDaoImpl implements CompteDao {
    @Override
    public List<Compte> findAll() {
        Connection connection=SingletonConnexionDB.getConnaction();
        List<Compte>comptes=new ArrayList<>();
        try{
            PreparedStatement stm1=connection.prepareStatement("select * from COMPTE");
            ResultSet rs1=stm1.executeQuery();
            while(rs1.next()){
                Compte c=new Compte();
                c.setId(rs1.getDouble("ID"));
                c.setNum_compte(rs1.getString("NUM_COMPTE"));
                c.setDate_creation(rs1.getDate("DATE_CREATION"));
                c.setSolde(rs1.getFloat("SOLDE"));
                c.setBloque(rs1.getBoolean("BLOQUE"));
               comptes.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return comptes ;
    }

    @Override
    public Compte findByID(double id) {
        Connection connection=SingletonConnexionDB.getConnaction();
        Compte c=new Compte();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from COMPTE where ID=?");
            stm.setDouble(1,id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNum_compte(rs.getString("NUM_COMPTE"));
                c.setDate_creation(rs.getDate("DATE_CREATION"));
                c.setSolde(rs.getFloat("SOLDE"));
                c.setBloque(rs.getBoolean("BLOQUE"));
             }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Compte save(Compte o) {
        Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("insert into COMPTE(NUM_COMPTE,DATE_CREATION,SOLDE,BLOQUE)"+" values(?,?,?,?)");
            pstm.setString(1,o.getNum_compte());
            pstm.setDate(2,o.getDate_creation());
            pstm.setFloat(3,o.getSolde());
            pstm.setBoolean(4,o.isBloque());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Compte o) {
        Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("delete from COMPTE where ID=?");
            pstm.setDouble(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Compte update(Compte o) {
        return null;
    }

    @Override
    public Compte bloquerCompte(Compte o) {
        Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("update COMPTE set PLOQUE=? where ID=?");
            pstm.setBoolean(1,o.isBloque());
            pstm.setDouble(2,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }


    @Override
    public float retirer(float f,Compte o) {
        Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("update COMPTE set SOLDE=? where ID=?");
            pstm.setFloat(1,o.getSolde());
            pstm.setDouble(2,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public float verser(float f,Compte o) {
        Connection connection=SingletonConnexionDB.getConnaction();
        try{
            PreparedStatement pstm=connection.prepareStatement("update COMPTE set SOLDE=? where ID=?");
            pstm.setFloat(1,o.getSolde());
            pstm.setDouble(2,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return f;
    }
}
