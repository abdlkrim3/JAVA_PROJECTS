package ma.enset.examen.dao;


import ma.enset.examen.dao.entities.Product;

public interface DaoProduct extends Dao<Product> {
    public Product getProduitByQuery();
}
