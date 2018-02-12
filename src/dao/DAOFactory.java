package dao;

// Note: you can use only domain.

import dao.impl.DbAspirantAccountDAO;

/**
 * Represents a simple DAO factory.
 */
public class DAOFactory {
    // This field must be static. (delete this)
    private static final DAOFactory factory = new DAOFactory();

    // Do not make myDAO and other fields like this static. (delete this)
    private final AspirantAccountDAO AspirantAccountDAO = new DbAspirantAccountDAO();

    private DAOFactory() {
    }

    /**
     * Returns an instance of the {@link DAOFactory} in singleton scope.
     * @return instance of the {@link DAOFactory}
     */
    public static DAOFactory getInstance() {
        return factory;
    }

    /**
     * Returns an instance of the {@link AspirantAccountDAO} in singleton scope.
     * @return instance of the {@link AspirantAccountDAO}
     */
    public AspirantAccountDAO getAspirantAccountDAO() {
        return AspirantAccountDAO;
    }

    // TODO: refactor code, add DAO.
}
