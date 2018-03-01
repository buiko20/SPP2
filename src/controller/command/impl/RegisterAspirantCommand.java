package controller.command.impl;

import controller.command.Command;
import domain.AspirantAccount;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.ServiceException;

/**
 * Represents an aspirant registration command.
 */
public class RegisterAspirantCommand implements Command{

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException {

        try {
            String[] aspirant = request.split(";");

            AspirantAccount aspirantAccount = new AspirantAccount(aspirant[0], aspirant[1], null);
            aspirantService.register(aspirantAccount);
        } catch (AspirantAlreadyExistsException e) {
            throw e;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
