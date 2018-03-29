package controller.command.impl.DocumentCommands;

import controller.command.Command;
import controller.command.impl.GetAspirantCommand;
import controller.command.impl.GetCompanyCommand;
import controller.command.impl.GetHRManagerCommand;
import controller.command.impl.InvitationCommands.GetInvitationCommand;
import controller.command.impl.JobVacancyCommands.GetJobVacancyCommand;
import controller.command.impl.ResumeCommands.GetResumeCommand;
import domain.Company;
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
 * Represents a pdf document create command.
 */
public class CreatePdfCommand implements Command {

    private final DocumentService documentService = ServiceFactory.getInstance().getDocumentService();
    private final String packagePath = "D:\\Hamelioniya\\university\\3 курс\\СПП(Java)\\Лаб№2-8\\Documents\\";

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException {

        String[] requestData = request.split(";");
        String fileName = "";

        request = requestData[0];
        for (int i = 1; i < requestData.length - 1; i++) {
            request += ";" + requestData[i];
        }

        switch (requestData[requestData.length - 1]){
            case("Resume"):{
                Command command = new GetResumeCommand();
                AspirantResume resume = (AspirantResume) command.execute(request);
                fileName = packagePath + "resume.pdf";

                documentService.createPdf(fileName, resume);
                break;
            }
            case("JobVacancy"): {
                Command command = new GetJobVacancyCommand();
                JobVacancy jobVacancy = (JobVacancy) command.execute(request);
                fileName = packagePath + "jobVacancy.pdf";

                documentService.createPdf(fileName, jobVacancy);
                break;
            }
            case("Invitation"):{
                Command command = new GetInvitationCommand();
                AspirantInvitation invitation = (AspirantInvitation) command.execute(request);
                fileName = packagePath + "invitation.pdf";

                documentService.createPdf(fileName, invitation);
                break;
            }
            case("Aspirant"): {
                Command command = new GetAspirantCommand();
                Aspirant aspirant = (Aspirant) command.execute(request);
                fileName = packagePath + "aspirant.pdf";

                documentService.createPdf(fileName, aspirant);
                break;
            }
            case("HRManager"): {
                Command command = new GetHRManagerCommand();
                HRManager hrManager = (HRManager) command.execute(request);
                fileName = packagePath + "hrManager.pdf";

                documentService.createPdf(fileName, hrManager);
                break;
            }
        }

        return fileName;
    }
}
