package service;

import domain.AspirantAccount;
import domain.AspirantProfile;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.ServiceException;

/**
 * Represents an AspirantService responsible for working with an aspirant.
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

    /**
     * Add aspirantProfile to aspirantAccount identifiable by email.
     * @param email aspirant email.
     * @param aspirantProfile aspirant profile.
     * @throws IllegalArgumentException when email is null, empty or whitespace or aspirantProfile is null.
     * @throws AspirantNotRegisteredException when aspirant is not registered in the system.
     * @throws ServiceException when an error occurred in service.
     */
    void addAspirantProfile(String email, AspirantProfile aspirantProfile) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException;

    /**
     * Returns an aspirant profile identifiable by aspirant account email.
     * @param email aspirant email.
     * @return An aspirant profile.
     * @throws IllegalArgumentException when email is null, empty or whitespace.
     * @throws AspirantNotRegisteredException when aspirant is not registered in the system.
     * @throws ServiceException when an error occurred in service.
     */
    AspirantProfile getAspirantProfile(String email) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException;

    /**
     * Updates existing aspirant profile identifiable by aspirant account email.
     * @param email aspirant email.
     * @param aspirantProfile aspirant profile.
     * @throws IllegalArgumentException when email is null, empty or whitespace or aspirantProfile is null.
     * @throws AspirantNotRegisteredException when aspirant is not registered in the system.
     * @throws AspirantProfileNotFoundException when aspirant profile not found. Aspirant account have no profile.
     * @throws ServiceException when an error occurred in service.
     */
    void updateAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ServiceException;

}
