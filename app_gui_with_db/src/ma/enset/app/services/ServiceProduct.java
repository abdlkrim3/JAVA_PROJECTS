package ma.enset.app.services;

import ma.enset.app.dao.entities.Product;

import java.util.*;

public interface ServiceProduct {
    List<Product> getAllProducts();
    void addProduct(Product p);
    void deleteProduct(Product p);
    List<Product> getProductByQuery(String query);
    void updateProduct(Product p);
}
