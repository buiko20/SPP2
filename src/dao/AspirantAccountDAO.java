package dao;

import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.List;

public interface AspirantAccountDAO {

    public List<AspirantAccount> getAll() throws DAOException;

    public AspirantAccount getById(int id) throws DAOException;

    public boolean update(AspirantAccount aspirantAccount) throws DAOException;

    public boolean delete(int id) throws DAOException;

    public boolean create(AspirantAccount aspirantAccount) throws DAOException;

}
