package ma.enset.examen.dao;


import ma.enset.examen.dao.entities.Category;
import ma.enset.examen.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoProductImp implements DaoProduct{

    @Override
    public List<Product> findALl() {
        List<Product> list = new ArrayList<>();
        Connection connection;
        try{
            connection = SingletonConnectionDB.getConnection();
            String query = "select * from PRODUITS";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()){
                Product p  = new Product();
                p.setId(res.getInt("ID"));
                p.setName(res.getString("NAME"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrice(res.getDouble("PRICE"));
                p.setQte(res.getInt("QTE"));
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM CATEGORIES WHERE ID  = ?");
                ps.setInt(1, res.getInt("ID"));
                ResultSet res2 = ps.executeQuery();
                if(res2.next()){
                    Category c = new Category();
                    c.setId(res2.getInt("ID"));
                    c.setName(res2.getString("NAME"));
                }

                list.add(p);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        Connection connection = SingletonConnectionDB.getConnection();
        try{

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUIT WHERE ID  = ?");
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();

            Product p = new Product();

            p.setId(res.getInt("ID"));
            p.setName(res.getString("NAME"));
            p.setDescription(res.getString("DESCRIPTION"));
            p.setPrice(res.getDouble("PRICE"));
            p.setQte(res.getInt("QTE"));
            return p;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Product save(Product a) {
        try{
            Connection connection = SingletonConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUITS(NAME, DESCRIPTION, PRICE,QTE, CATID) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,a.getName());
            preparedStatement.setString(2,a.getDescription());
            preparedStatement.setDouble(3,a.getPrice());
            preparedStatement.setInt(4,a.getQte());
            preparedStatement.setInt(5,a.getCategory().getId());
            preparedStatement.executeUpdate();
            return a;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Product a) {
        try{
            Connection connection = SingletonConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID = ?");
            preparedStatement.setInt(1,a.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product update(Product a) {
        try{
            System.out.println(a.getId());
            Connection connection = SingletonConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Update PRODUITS SET NAME = ?, DESCRIPTION = ?, PRICE = ?, QTE = ?, CATID=? WHERE ID=?");
            preparedStatement.setString(1,a.getName());
            preparedStatement.setString(2,a.getDescription());
            preparedStatement.setDouble(3,a.getPrice());
            preparedStatement.setInt(4,a.getQte());
            preparedStatement.setInt(5,a.getCategory().getId());
            preparedStatement.setInt(6,a.getId());
            preparedStatement.executeUpdate();

            return a;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getProduitByQuery() {
        return null;
    }
}
