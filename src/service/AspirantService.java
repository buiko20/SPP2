package service;

import domain.AspirantAccount;
import service.exception.ServiceException;

/**
 * Represents a AspirantService.
 */
public interface AspirantService {

    /**
     * Returns {@link AspirantAccount} with specific email.
     * @param email aspirant email.
     * @return instance of {@link AspirantAccount} or null
     * if AspirantAccount with specific email  not found.
     * @throws ServiceException when error occurred in service.
     * @throws IllegalArgumentException when email is null, empty or white space.
     */
    AspirantAccount getAspirantAccountByEmail(String email) throws ServiceException;

}
