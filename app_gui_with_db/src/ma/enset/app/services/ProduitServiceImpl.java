package ma.enset.app.services;

import ma.enset.app.dao.DaoProduct;
import ma.enset.app.dao.entities.Product;

import java.util.List;

public class ProduitServiceImpl implements ServiceProduct {

    DaoProduct pdao;

    public ProduitServiceImpl(DaoProduct pdao){
        this.pdao = pdao;
    }

    @Override
    public List<Product> getAllProducts() {
        return pdao.findAll();
    }

    @Override
    public void addProduct(Product p) {
        pdao.save(p);
    }

    @Override
    public void deleteProduct(Product p) {
        pdao.delete(p);
    }

    @Override
    public List<Product> getProductByQuery(String query) {
        return pdao.getProduitByQuery(query);
    }

    @Override
    public void updateProduct(Product p) {
        pdao.update(p);
    }
}
