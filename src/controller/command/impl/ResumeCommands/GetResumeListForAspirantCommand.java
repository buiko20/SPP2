package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Represents a resume list get command for aspirant.
 */
public class GetResumeListForAspirantCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException {

        ArrayList<Resume> resumes = aspirantService.getAllAspirantResume(request);

        return resumes;
    }
}
