package controller.command.impl;

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

        AspirantProfile aspirantProfile = new AspirantProfile(aspirant[1], aspirant[2], aspirant[3], aspirant[4], aspirant[5],
                aspirant[6], Date.valueOf(aspirant[7]), aspirant[8], aspirant[9], aspirant[10], aspirant[11], aspirant[12]);
        aspirantService.updateAspirantProfile(aspirant[0], aspirantProfile);

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(currentDate);

        Resume resume = new Resume(Timestamp.valueOf(curStringDate), aspirant[13], Boolean.valueOf(aspirant[14]),
                Boolean.valueOf(aspirant[15]), aspirant[16], Float.valueOf(aspirant[17]),0, aspirantService.getAspirantAccountByEmail(aspirant[0]).getId());

        aspirantService.updateAspirantResume(aspirant[0], aspirant[13], resume);
        return null;
    }
}
