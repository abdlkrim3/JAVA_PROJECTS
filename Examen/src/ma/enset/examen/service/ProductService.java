package ma.enset.examen.service;

import ma.enset.examen.dao.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getALl();
    Product findById(int id);
    Product add(Product a);
    boolean delete(Product a);
    Product update(Product a);
}
