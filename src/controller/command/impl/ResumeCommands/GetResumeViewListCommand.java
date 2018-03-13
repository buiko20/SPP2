package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.ResumeView;
import service.AspirantService;
import service.CompanyService;
import service.ServiceFactory;
import service.exception.*;

import java.util.ArrayList;

/**
 * Represents a resume view list get command.
 */
public class GetResumeViewListCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();
    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        ArrayList<viewModel.ResumeView> newResumeViewList = new ArrayList<>();

        ArrayList<ResumeView> oldResumeViewList = aspirantService.getAllAspirantResumeViews(requestData[0], requestData[1]);

        for (ResumeView oldResumeView : oldResumeViewList) {

            viewModel.ResumeView newResumeView = new viewModel.ResumeView(oldResumeView.getDate(), companyService.getCompanyById(oldResumeView.getCompanyId()).getName());
            newResumeViewList.add(newResumeView);
        }

        return newResumeViewList;
    }
}
