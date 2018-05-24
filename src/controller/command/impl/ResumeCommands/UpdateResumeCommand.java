package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.AspirantProfile;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Represents a resume update command.
 */
public class UpdateResumeCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        String[] aspirant = request.split(";");

        AspirantProfile aspirantProfile = new AspirantProfile(aspirant[2], aspirant[3], aspirant[4], aspirant[5], aspirant[6],
                aspirant[7], Date.valueOf(aspirant[8]), aspirant[9], aspirant[10], aspirant[11], aspirant[12], aspirant[13]);
        aspirantService.updateAspirantProfile(aspirant[1], aspirantProfile);

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);

        Resume resume = new Resume(Timestamp.valueOf(curStringDate), aspirant[14], Boolean.valueOf(aspirant[15]),
                Boolean.valueOf(aspirant[16]), aspirant[17], Float.valueOf(aspirant[18]),aspirantService.getAllAspirantResumeViews(aspirant[1], aspirant[0]).size(),
                aspirantService.getAspirantAccountByEmail(aspirant[1]).getId());

        aspirantService.updateAspirantResume(aspirant[1], aspirant[0], resume);

        return null;
    }
}
