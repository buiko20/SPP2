package controller.command.impl;

import controller.command.Command;
import domain.AspirantAccount;
import service.AspirantService;
import service.AuthService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.ServiceException;

/**
 * Represents an aspirant registration command.
 */
public class RegisterAspirantCommand implements Command{

    private final AuthService authService = ServiceFactory.getInstance().getAuthService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException {

        try {
            String[] aspirant = request.split(";");

            AspirantAccount aspirantAccount = new AspirantAccount(aspirant[0], aspirant[1], null);
            authService.registerAspirant(aspirantAccount);
        } catch (AspirantAlreadyExistsException e) {
            throw e;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
