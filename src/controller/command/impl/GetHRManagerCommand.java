package controller.command.impl;

import controller.command.Command;
import service.HRManagerService;
import service.ServiceFactory;
import service.exception.*;

/**
 * Represents a HR manager get command.
 */
public class GetHRManagerCommand implements Command {

    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException {

        return hrManagerService.getHRManagerByEmail(request);
    }
}
