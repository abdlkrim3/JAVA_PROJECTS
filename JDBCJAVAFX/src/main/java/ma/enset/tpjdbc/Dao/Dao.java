package ma.enset.tpjdbc.Dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
    List<T> findAll();
    T findByID(int id);
    T save(T o);
    boolean delete(T o);
    T update(T o);
}
