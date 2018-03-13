package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import domain.HRManager;
import domain.JobVacancy;
import service.CompanyService;
import service.HRManagerService;
import service.JobVacancyService;
import service.ServiceFactory;
import service.exception.*;

/**
 * Represents a job vacancy get command.
 */
public class GetJobVacancyCommand implements Command {

    private final JobVacancyService jobVacancyService = ServiceFactory.getInstance().getJobVacancyService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");
        //TODO: вызвать правильный метод

        //JobVacancy oldJobVacancy = jobVacancyService.getJobVacancy(requestData[0], requestData[1]);
        //HRManager hrManager = hrManagerService.getHRManagerById(oldJobVacancy.getHrManagerId());

        JobVacancy oldJobVacancy = jobVacancyService.getJobVacancy(requestData[1]);
        HRManager hrManager = hrManagerService.getHRManagerByEmail("user@gmail.com");

        viewModel.JobVacancy newJobVacancy = new viewModel.JobVacancy(oldJobVacancy.getStatus(),
                oldJobVacancy.getName(), oldJobVacancy.getDate(), companyService.getCompanyById(oldJobVacancy.getCompanyId()).getName(),
                hrManager.getSurname(), hrManager.getName(), hrManager.getPhoneNumber(), hrManager.getEmail(),
                oldJobVacancy.getDescription(), oldJobVacancy.getAddress());

        return newJobVacancy;
    }
}
