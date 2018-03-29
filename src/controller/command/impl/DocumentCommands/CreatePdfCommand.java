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

        request = requestData[0];
        for (int i = 1; i < requestData.length - 1; i++) {
            request += ";" + requestData[i];
        }

        switch (requestData[requestData.length - 1]){
            case("Resume"):{
                Command command = new GetResumeCommand();
                AspirantResume resume = (AspirantResume) command.execute(request);

                documentService.createPdf(packagePath + "resume.pdf", resume);
                break;
            }
            case("JobVacancy"): {
                Command command = new GetJobVacancyCommand();
                JobVacancy jobVacancy = (JobVacancy) command.execute(request);

                documentService.createPdf(packagePath + "jobVacancy.pdf", jobVacancy);
                break;
            }
            case("Invitation"):{
                Command command = new GetInvitationCommand();
                AspirantInvitation invitation = (AspirantInvitation) command.execute(request);
                documentService.createPdf(packagePath + "invitation.pdf", invitation);
                // /documentService.createPdf(requestData[requestData.length - 2], resume);
                break;
            }
            case("Aspirant"): {
                Command command = new GetAspirantCommand();
                Aspirant aspirant = (Aspirant) command.execute(request);

                documentService.createPdf(packagePath + "aspirant.pdf", aspirant);
                break;
            }
            case("HRManager"): {
                Command command = new GetHRManagerCommand();
                HRManager hrManager = (HRManager) command.execute(request);

                documentService.createPdf(packagePath + "hrManager.pdf", hrManager);
                break;
            }
        }
        return null;
    }
}
