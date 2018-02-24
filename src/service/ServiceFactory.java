package service;

import dao.DAO;
import dao.DAOFactory;
import domain.AspirantAccount;
import service.impl.MyAspirantService;

/**
 * Represents a simple service factory.
 */
public class ServiceFactory {
    private static final ServiceFactory factory = new ServiceFactory();

    private final DAO<AspirantAccount> AspirantAccountDao = DAOFactory.getInstance().getAspirantAccountDAO();

    private final AspirantService aspirantService = new MyAspirantService(AspirantAccountDao);

    private ServiceFactory() {
    }

    /**
     * Returns an instance of the {@link ServiceFactory} in singleton scope.
     * @return instance of the {@link ServiceFactory}
     */
    public static ServiceFactory getInstance() {
        return factory;
    }

    /**
     * Returns an instance of the {@link AspirantService} in singleton scope.
     * @return instance of the {@link AspirantService}
     */
    public AspirantService getAspirantService() {
        return aspirantService;
    }
}
