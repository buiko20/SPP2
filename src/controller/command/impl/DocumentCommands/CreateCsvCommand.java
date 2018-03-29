package controller.command.impl.DocumentCommands;

import controller.command.Command;
import controller.command.impl.GetAspirantCommand;
import controller.command.impl.InvitationCommands.GetInvitationCommand;
import controller.command.impl.JobVacancyCommands.GetJobVacancyCommand;
import controller.command.impl.ResumeCommands.GetResumeCommand;
import domain.HRManager;
import service.DocumentService;
import service.HRManagerService;
import service.ServiceFactory;
import service.exception.*;
import viewModel.Aspirant;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;
import viewModel.JobVacancy;

/**
 * Represents a csv document create command.
 */
public class CreateCsvCommand implements Command {

    private final DocumentService documentService = ServiceFactory.getInstance().getDocumentService();
    private final String packagePath = "D:\\Hamelioniya\\university\\3 курс\\СПП(Java)\\Лаб№2-8\\Documents\\";

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException {
        String[] requestData = request.split(";");

        request = requestData[0];
        for (int i = 1; i < requestData.length - 1; i++) {
            request += ";" + requestData[i];
        }

        switch (requestData[requestData.length - 1]){
            case("Resume"):{
                Command command = new GetResumeCommand();
                AspirantResume resume = (AspirantResume) command.execute(request);

                documentService.createCsv(packagePath + "resume.csv", resume);
                break;
            }
            case("JobVacancy"): {
                Command command = new GetJobVacancyCommand();
                JobVacancy jobVacancy = (JobVacancy) command.execute(request);

                documentService.createCsv(packagePath + "jobVacancy.csv", jobVacancy);
                break;
            }
            case("Invitation"):{
                Command command = new GetInvitationCommand();
                AspirantInvitation invitation = (AspirantInvitation) command.execute(request);

                documentService.createCsv(packagePath + "invitation.csv", invitation);
                break;
            }
            case("Aspirant"): {
                Command command = new GetAspirantCommand();
                Aspirant aspirant = (Aspirant) command.execute(request);

                documentService.createPdf(packagePath + "aspirant.csv", aspirant);
                break;
            }
            case("HRManager"): {
                HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();
                HRManager hrManager = hrManagerService.getHRManagerByEmail(request);

                documentService.createPdf(packagePath + "hrManager.csv", hrManager);
                break;
            }
        }
        return null;
    }
}
