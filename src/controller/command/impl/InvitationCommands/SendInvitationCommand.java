package controller.command.impl.InvitationCommands;

import controller.command.Command;
import service.AspirantService;
import service.CompanyService;
import service.HRManagerService;
import service.ServiceFactory;
import service.exception.*;

/**
 * Represents an invitation send command.
 */
public class SendInvitationCommand implements Command {


    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService  = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException {



        return null;
    }
}
