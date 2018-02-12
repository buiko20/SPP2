package dao.impl;

import dao.AspirantAccountDAO;
import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.List;

public class DbAspirantAccountDAO implements AspirantAccountDAO{
    public List<AspirantAccount> getAll() throws DAOException {
        return null;
    }

    public AspirantAccount getById(int id) throws DAOException {
        return null;
    }

    public boolean update(AspirantAccount aspirantAccount) throws DAOException {
        return false;
    }

    public boolean delete(int id) throws DAOException {
        return false;
    }

    public boolean create(AspirantAccount aspirantAccount) throws DAOException {
        return false;
    }
}
