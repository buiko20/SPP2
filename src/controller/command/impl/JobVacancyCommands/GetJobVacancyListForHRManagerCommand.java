package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import domain.Company;
import domain.HRManager;
import domain.JobVacancy;
import service.CompanyService;
import service.HRManagerService;
import service.ServiceFactory;
import service.exception.*;

import java.util.ArrayList;

public class GetJobVacancyListForHRManagerCommand implements Command {

    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        ArrayList<viewModel.JobVacancy> newJobVacancyList = new ArrayList<>();

        Company company = companyService.getCompanyById(hrManagerService.getHRManagerByEmail(request).getCompanyId());
        ArrayList<JobVacancy> oldJobVacancyList = hrManagerService.getAllVacanciesOfCompany(company.getName());

        for (JobVacancy oldJobVacancy : oldJobVacancyList) {

            HRManager hrManager = hrManagerService.getHRManagerById(oldJobVacancy.getHrManagerId());

            viewModel.JobVacancy newJobVacancy = new viewModel.JobVacancy(oldJobVacancy.getStatus(),
                    oldJobVacancy.getName(), oldJobVacancy.getDate(), companyService.getCompanyById(oldJobVacancy.getCompanyId()).getName(),
                    hrManager.getSurname(), hrManager.getName(), hrManager.getPhoneNumber(), hrManager.getEmail(),
                    oldJobVacancy.getDescription(), oldJobVacancy.getAddress());
            newJobVacancyList.add(newJobVacancy);
        }

        return newJobVacancyList;
    }
}
