package service;

import domain.AspirantAccount;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

/**
 * Represents an AspirantService.
 */
public interface AspirantService {

    /**
     * Adds an aspirant to the system.
     * @param aspirantAccount aspirant account
     * @throws IllegalArgumentException when aspirantAccount is null.
     * @throws AspirantAlreadyExistsException when aspirant already exists in the system.
     * @throws ServiceException when an error occurred in service.
     */
    void register(AspirantAccount aspirantAccount) throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException;

    /**
     * Checks an aspirant credentials.
     * @param email aspirant email
     * @param password aspirant password
     * @return true if email and password are correct otherwise false.
     * @throws IllegalArgumentException when email or password is null, empty or whitespace.
     * @throws AspirantNotRegisteredException when aspirant is not registered in the system.
     * @throws ServiceException when an error occurred in service.
     */
    boolean isValidCredentials(String email, String password) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException;

    /**
     * Returns {@link AspirantAccount} with specific email.
     * @param email aspirant email.
     * @return instance of {@link AspirantAccount} or null
     * if AspirantAccount with specific email  not found.
     * @throws ServiceException when error occurred in service.
     * @throws IllegalArgumentException when email is null, empty or white space.
     */
    AspirantAccount getAspirantAccountByEmail(String email) throws IllegalArgumentException, ServiceException;

}
