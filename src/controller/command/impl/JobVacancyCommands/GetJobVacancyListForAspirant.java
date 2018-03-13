package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import domain.HRManager;
import domain.JobVacancy;
import service.CompanyService;
import service.HRManagerService;
import service.JobVacancyService;
import service.ServiceFactory;
import service.exception.*;

import java.util.ArrayList;

public class GetJobVacancyListForAspirant implements Command {

    private final JobVacancyService jobVacancyService = ServiceFactory.getInstance().getJobVacancyService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        ArrayList<viewModel.JobVacancy> newJobVacancyList = new ArrayList<>();
        ArrayList<JobVacancy> oldJobVacancyList = jobVacancyService.getAllAspirantJobVacancy();

        for (JobVacancy oldJobVacancy : oldJobVacancyList) {
            //TODO: вызвать правильный метод
            //HRManager hrManager = hrManagerService.getHRManagerById(oldJobVacancy.getHrManagerId());

            HRManager hrManager = hrManagerService.getHRManagerByEmail("user@gmail.com");

            viewModel.JobVacancy newJobVacancy = new viewModel.JobVacancy(oldJobVacancy.getStatus(),
                    oldJobVacancy.getName(), oldJobVacancy.getDate(), companyService.getCompanyById(oldJobVacancy.getCompanyId()).getName(),
                    hrManager.getSurname(), hrManager.getName(), hrManager.getPhoneNumber(), hrManager.getEmail(),
                    oldJobVacancy.getDescription(), oldJobVacancy.getAddress());
            newJobVacancyList.add(newJobVacancy);
        }

        return newJobVacancyList;
    }
}
