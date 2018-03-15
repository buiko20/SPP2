package controller.command.impl.InvitationCommands;

import controller.command.Command;
import domain.HRManager;
import domain.Invitation;
import service.*;
import service.exception.*;
import viewModel.AspirantInvitation;

import java.util.ArrayList;

/**
 * Represents an invitation list get command for aspirant.
 */
public class GetInvitationListForAspirantCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final JobVacancyService jobVacancyService  = ServiceFactory.getInstance().getJobVacancyService();
    private final HRManagerService hrManagerService  = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        ArrayList<AspirantInvitation> newInvitationList = new ArrayList<>();
        ArrayList<Invitation> oldInvitationList = aspirantService.getAllAspirantInvitations(request);

        for (Invitation oldInvitation : oldInvitationList) {

            HRManager hrManager = hrManagerService.getHRManagerById(oldInvitation.getHrManagerId());

            AspirantInvitation newInvitation = new AspirantInvitation(oldInvitation.getDate(), oldInvitation.getAddress(), request,
                    aspirantService.getResumeById(oldInvitation.getResumeId()).getCareerObjective(), companyService.getCompanyById(oldInvitation.getCompanyId()).getName(),
                    jobVacancyService.getJobVacancyById(oldInvitation.getResumeId()).getName(), hrManager.getSurname(), hrManager.getName(),
                    hrManager.getPhoneNumber(), hrManager.getEmail());
            newInvitationList.add(newInvitation);
        }

        return newInvitationList;
    }
}
