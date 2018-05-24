package controller.command.impl.InvitationCommands;

import controller.command.Command;
import domain.HRManager;
import domain.Invitation;
import service.*;
import service.exception.*;
import viewModel.AspirantInvitation;

/**
 * Represents an invitation get command.
 */
public class GetInvitationCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService  = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        Invitation oldInvitation = aspirantService.getInvitation(requestData[0], requestData[1], requestData[2], requestData[3]);

        HRManager hrManager = hrManagerService.getHRManagerById(oldInvitation.getHrManagerId());

        AspirantInvitation newInvitation = new AspirantInvitation(oldInvitation.getDate(), oldInvitation.getAddress(),
                requestData[0], requestData[1] ,requestData[3], requestData[2],
                hrManager.getSurname(), hrManager.getName(), hrManager.getPhoneNumber(), hrManager.getEmail());

        return newInvitation;
    }
}
