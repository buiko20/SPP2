package dao;

import dao.exception.DAOException;

import java.util.List;
import java.util.function.Predicate;

public interface DAO<T> {

    List<T> getAll() throws DAOException;

    T getBy(Predicate<T> predicate) throws DAOException;

    void update(T entity) throws DAOException;

    void delete(int id) throws DAOException;

    void create(T entity) throws DAOException;

}
