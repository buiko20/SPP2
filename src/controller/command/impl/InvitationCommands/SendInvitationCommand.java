package controller.command.impl.InvitationCommands;

import controller.command.Command;
import domain.Invitation;
import service.*;
import service.exception.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Represents an invitation send command.
 */
public class SendInvitationCommand implements Command {


    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService  = ServiceFactory.getInstance().getHrManagerService();
    private final JobVacancyService jobVacancyService  = ServiceFactory.getInstance().getJobVacancyService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException {

        String[] requestData = request.split(";");

        String[] curStringDate = requestData[5].split("T");
        String date = curStringDate[0] + " " + curStringDate[1] + ":00";

        Invitation invitation = new Invitation(Timestamp.valueOf(date), requestData[4], 0,
                0, 0, 0, 0);

        aspirantService.sendInvitation(requestData[1], requestData[2], requestData[3], requestData[0], invitation);

        return null;
    }
}
