package ma.enset.examen.service;

import ma.enset.examen.dao.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getALl();
    Category findById(int id);
    Category add(Category a);
    boolean delete(Category a);
    Category update(Category a);
}
