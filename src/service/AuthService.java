package service;

import domain.AspirantAccount;
import service.exception.AspirantAlreadyExistsException;
import service.exception.ServiceException;

public interface AuthService {

    /**
     * Adds an aspirant to the system.
     * @param aspirantAccount aspirant account
     * @throws IllegalArgumentException when aspirantAccount is null.
     * @throws AspirantAlreadyExistsException when aspirant already exists in the system.
     * @throws ServiceException when an error occurred in service.
     */
    void registerAspirant(AspirantAccount aspirantAccount)
            throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException;

    /**
     * Checks user credentials.
     * @param email user email
     * @param password user password
     * @return user role if email and password are correct otherwise empty string "" or "error".
     * For valid aspirant returns "aspirant", for valid hr - "hr". If user Credentials are wrong
     * then "error" returned. If user does not exist "" returned.
     * @throws IllegalArgumentException when email or password is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    String isValidAspirantCredentials(String email, String password)
            throws IllegalArgumentException, ServiceException;

}
