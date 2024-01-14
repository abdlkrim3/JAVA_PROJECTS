package ma.enset.examen.Dao;

import java.util.List;

public interface Dao <T>{
    List<T> findAll();
    T findByID(double id);
    T save(T o);
    boolean delete(T o);
    T update(T o);
}
