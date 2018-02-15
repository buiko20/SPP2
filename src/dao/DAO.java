package dao;

import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.List;
import java.util.function.Predicate;

public interface DAO<T> {

    List<T> getAll() throws DAOException;

    // return null if not found.
    T getBy(Predicate<T> predicate) throws DAOException;

    void update(T entity) throws DAOException;

    void delete(T entity) throws DAOException;

    void create(T entity) throws DAOException;

}
