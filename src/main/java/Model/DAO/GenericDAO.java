package Model.DAO;


import java.util.List;

public interface GenericDAO<T> {
    void save(T entity);
    T findById(int id);
    void update(T entity);
    void delete(T entity);
}

