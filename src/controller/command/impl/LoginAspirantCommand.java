package controller.command.impl;

import controller.command.Command;
import service.AuthService;
import service.ServiceFactory;
import service.exception.ServiceException;

/**
 * Represents an aspirant login command.
 */
public class LoginAspirantCommand implements Command {

    private final AuthService authService = ServiceFactory.getInstance().getAuthService();

    @Override
    public Object execute(String request) throws ServiceException {

        String[] aspirant = request.split(";");

        return authService.isValidAspirantCredentials(aspirant[0], aspirant[1]);
    }
}
