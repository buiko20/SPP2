package controller.command.impl;

import controller.command.Command;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Represents a resume list getting command.
 */
public class GetResumeListCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException {

        //TODO: получить список резюме
        Resume r = new Resume(Date.valueOf("1998-05-10"), "Крутой парень", true, false, "", Float.valueOf(1), 0, 1);
        ArrayList<Resume> resumes = new ArrayList<>();
        resumes.add(r);
        return resumes;
    }
}
