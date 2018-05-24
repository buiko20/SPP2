package controller.command.impl.JobVacancyCommands;

import controller.command.Command;
import domain.Company;
import domain.JobVacancy;
import service.CompanyService;
import service.HRManagerService;
import service.JobVacancyService;
import service.ServiceFactory;
import service.exception.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UpdateJobVacancyCommand implements Command{

    private final JobVacancyService jobVacancyService = ServiceFactory.getInstance().getJobVacancyService();
    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException {

        String[] requestData = request.split(";");

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:s").format(currentDate);

        JobVacancy jobVacancy = new JobVacancy(requestData[2], Timestamp.valueOf(curStringDate), requestData[3],
                requestData[4], requestData[5], 0, 0);

        hrManagerService.updateJobVacancy(requestData[0], companyService.getCompanyById(hrManagerService.getHRManagerByEmail(requestData[1]).getCompanyId()).getName(), jobVacancy);

        return null;
    }
}
