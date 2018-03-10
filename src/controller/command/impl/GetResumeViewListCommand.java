package controller.command.impl;

import controller.command.Command;
import domain.ResumeView;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;

import java.sql.Timestamp;
import java.util.ArrayList;

public class GetResumeViewListCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        ArrayList<viewModel.ResumeView> viewList = new ArrayList<>();

        /*ArrayList<ResumeView> resumeViewList = aspirantService.getAllAspirantResumeView(requestData[0], requestData[1]);
        for (ResumeView view : resumeViewList) {
            viewModel.ResumeView resumeView = new viewModel.ResumeView(view.getDate(), aspirantService.getCompany(view.getId()).name);
            viewList.add(resumeView);
        }*/

        return viewList;
    }
}
