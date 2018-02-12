package service;

/**
 * Represents a simple service factory.
 */
public class ServiceFactory {
    private static final ServiceFactory factory = new ServiceFactory();

    private ServiceFactory() {
    }

    /**
     * Returns an instance of the {@link ServiceFactory} in singleton scope.
     * @return instance of the {@link ServiceFactory}
     */
    public static ServiceFactory getInstance() {
        return factory;
    }
}
