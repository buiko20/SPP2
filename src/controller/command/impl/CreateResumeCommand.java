package controller.command.impl;

import controller.command.Command;
import domain.AspirantProfile;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;
import java.sql.Date;

/**
 * Represents an resume creation command.
 */
public class CreateResumeCommand implements Command{

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException {

        String[] aspirant = request.split(";");

        AspirantProfile aspirantProfile = new AspirantProfile(aspirant[1], aspirant[2], aspirant[3], aspirant[4], aspirant[5],
                Date.valueOf(aspirant[6]), aspirant[7], aspirant[8], aspirant[9], aspirant[10], aspirant[11]);
        aspirantService.addAspirantProfile(aspirant[0], aspirantProfile);

        return null;
    }
}
