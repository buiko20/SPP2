package controller.command.impl.ResumeCommands;

import controller.command.Command;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a resume date update command.
 */
public class UpdateResumeDateCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);

        aspirantService.updateAspirantResumeDate(requestData[0], requestData[1], Timestamp.valueOf(curStringDate));

        return null;
    }
}
