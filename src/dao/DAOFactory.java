package dao;

import dao.impl.DbAspirantAccountDAO;
import domain.AspirantAccount;

/**
 * Represents a simple DAO factory.
 */
public class DAOFactory {

    private static final DAOFactory factory = new DAOFactory();

    private final DAO<AspirantAccount> AspirantAccountDAO = new DbAspirantAccountDAO();

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
     * Returns an instance of the {@link DAO} in singleton scope.
     * @return instance of the {@link DAO}
     */
    public DAO<AspirantAccount> getAspirantAccountDAO() {
        return AspirantAccountDAO;
    }
}
