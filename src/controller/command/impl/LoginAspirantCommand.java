package controller.command.impl;

import controller.command.Command;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

/**
 * Represents an aspirant login command.
 */
public class LoginAspirantCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantNotRegisteredException {

        try {
            String[] aspirant = request.split(";");

            if (aspirantService.isValidCredentials(aspirant[0], aspirant[1]))
                return new Object();
        } catch (AspirantNotRegisteredException e) {
            throw e;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
