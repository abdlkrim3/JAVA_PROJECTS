package ma.enset.app.dao;

import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoProductImpl implements DaoProduct {

    @Override
    public List<Product> findAll() {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS");
            return getProduits(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Product> getProduits(PreparedStatement stm) throws SQLException {
        ResultSet rs = stm.executeQuery();
        List<Product> listProduit = new ArrayList<>();
        while(rs.next()){
            Product p = new Product();
            p.setId(rs.getInt("ID"));
            p.setNom(rs.getString("NOM"));
            p.setDescreption(rs.getString("DESCREPTION"));
            p.setPrix(rs.getFloat("PRIX"));
            p.setQuantite(rs.getInt("QUANTITE"));
            listProduit.add(p);
        }
        return listProduit;
    }

    @Override
    public Product findById(int id) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS where ID = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Product p = new Product();
            if(rs.next()){
                p.setId(rs.getInt("ID"));
                p.setNom(rs.getString("NOM"));
                p.setDescreption(rs.getString("DESCREPTION"));
                p.setPrix(rs.getFloat("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
                return p;
            }
            else{
                return null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product save(Product o) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("insert into PRODUITS(NOM, DESCREPTION, PRIX, QUANTITE)" +
                    "values (?, ?, ?, ?)");
            stm.setString(1, o.getNom());
            stm.setString(2, o.getDescreption());
            stm.setFloat(3, o.getPrix());
            stm.setInt(4, o.getQuantite());
            stm.executeUpdate();
            return o;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Product o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from PRODUITS where ID = ?");
            stm.setInt(1, o.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Product update(Product o) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("update PRODUITS set NOM = ?, DESCREPTION = ?, PRIX = ?, QUANTITE = ? where ID = ?");
            stm.setString(1, o.getNom());
            stm.setString(2, o.getDescreption());
            stm.setFloat(3, o.getPrix());
            stm.setInt(4, o.getQuantite());
            stm.setInt(5, o.getId());
            stm.executeUpdate();
            return o;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProduitByQuery(String query) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS where NOM like ? or DESCREPTION LIKE ?");
            stm.setString(1, "%" + query + "%");
            stm.setString(2, "%" + query + "%");
            return getProduits(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProduitByCategory(Category c) {
        return null;
    }
}
