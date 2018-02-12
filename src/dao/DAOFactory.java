package dao;

import dao.impl.DbMyDAO;

// Note: you can use only domain.

/**
 * Represents a simple DAO factory.
 */
public class DAOFactory {
    // This field must be static. (delete this)
    private static final DAOFactory factory = new DAOFactory();

    // Do not make myDAO and other fields like this static. (delete this)
    private final MyDAO MyDAO = new DbMyDAO();

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
     * Returns an instance of the {@link MyDAO} in singleton scope.
     * @return instance of the {@link MyDAO}
     */
    public MyDAO getMyDAO() {
        return MyDAO;
    }

    // TODO: refactor code, add DAO.
}
