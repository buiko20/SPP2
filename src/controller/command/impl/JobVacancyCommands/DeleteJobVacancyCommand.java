package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import service.HRManagerService;
import service.JobVacancyService;
import service.ServiceFactory;
import service.exception.*;

public class DeleteJobVacancyCommand implements Command {

    private final JobVacancyService jobVacancyService = ServiceFactory.getInstance().getJobVacancyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException {

        String[] requestData = request.split(";");
        hrManagerService.deleteJobVacancy(requestData[0], requestData[1]);

        return null;
    }
}
