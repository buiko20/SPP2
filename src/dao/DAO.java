package dao;

import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.List;

public interface DAO<Type> {

    List<Type> getAll() throws DAOException;

    Type getById(int id) throws DAOException;

    boolean update(Type data) throws DAOException;

    boolean delete(int id) throws DAOException;

    boolean create(Type data) throws DAOException;

}
