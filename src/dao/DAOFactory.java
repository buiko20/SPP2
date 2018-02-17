package dao;

import dao.impl.DbAspirantAccountDAO;
import dao.impl.DbAspirantProfileDAO;
import domain.AspirantAccount;
import domain.AspirantProfile;

/**
 * Represents a simple DAO factory.
 */
public class DAOFactory {

    private static final DAOFactory factory = new DAOFactory();

    private final DbAspirantProfileDAO AspirantProfileDAO = new DbAspirantProfileDAO();
    private final DbAspirantAccountDAO AspirantAccountDAO = new DbAspirantAccountDAO();

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
     * Returns an instance of the {@link DAO<AspirantAccount>} in singleton scope.
     * @return instance of the {@link DAO<AspirantAccount>}
     */
    public DAO<AspirantAccount> getAspirantAccountDAO() {
        this.AspirantAccountDAO.setAspirantProfileDAO(this.AspirantProfileDAO);
        return AspirantAccountDAO;
    }

    /**
     * Returns an instance of the {@link DAO<AspirantProfile>} in singleton scope.
     * @return instance of the {@link DAO<AspirantProfile>}
     */
    public DAO<AspirantProfile> getAspirantProfileDAO() {
        return AspirantProfileDAO;
    }
}
