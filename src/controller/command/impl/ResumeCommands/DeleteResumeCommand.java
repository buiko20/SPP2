package controller.command.impl;

import controller.command.Command;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;

/**
 * Represents a resume delete command.
 */
public class DeleteResumeCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {
        String[] requestData = request.split(";");

        aspirantService.deleteAspirantResume(requestData[0], requestData[1]);
        return null;
    }
}
