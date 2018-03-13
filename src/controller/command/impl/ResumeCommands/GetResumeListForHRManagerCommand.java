package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.Resume;
import service.AspirantService;
import service.HRManagerService;
import service.ServiceFactory;
import service.exception.*;
import viewModel.AspirantResume;

import java.util.ArrayList;

/**
 * Represents a resume list get command for HR manager.
 */
public class GetResumeListForHRManagerCommand implements Command {

    private final HRManagerService hrManagerService = ServiceFactory.getInstance().getHrManagerService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        ArrayList<Resume> resumes = hrManagerService.getAllResume();

        return resumes;
    }
}
