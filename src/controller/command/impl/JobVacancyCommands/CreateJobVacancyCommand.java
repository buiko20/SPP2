package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import domain.JobVacancy;
import service.HRManagerService;
import service.JobVacancyService;
import service.ServiceFactory;
import service.exception.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Represents a job vacancy create command.
 */
public class CreateJobVacancyCommand implements Command {

    private final JobVacancyService jobVacancyService = ServiceFactory.getInstance().getJobVacancyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:s").format(currentDate);

        JobVacancy jobVacancy = new JobVacancy(requestData[1], Timestamp.valueOf(curStringDate), requestData[2],
                requestData[3], requestData[4], hrManagerService.getHRManagerByEmail(requestData[0]).getId(),
                hrManagerService.getHRManagerByEmail(requestData[0]).getCompanyId());

        jobVacancyService.addJobVacancy(jobVacancy);

        return null;
    }
}
