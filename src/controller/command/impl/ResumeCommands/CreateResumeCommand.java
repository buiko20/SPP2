package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.AspirantProfile;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.ServiceException;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Represents an resume create command.
 */
public class CreateResumeCommand implements Command{

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException {

        String[] requestData = request.split(";");

        if(aspirantService.getAspirantProfile(requestData[0]) == null){
            AspirantProfile aspirantProfile = new AspirantProfile(requestData[1], requestData[2], requestData[3], requestData[4], requestData[5],
                   requestData[6], Date.valueOf(requestData[7]), requestData[8], requestData[9], requestData[10], requestData[11], requestData[12]);
            aspirantService.addAspirantProfile(requestData[0], aspirantProfile);
        } else{
            AspirantProfile aspirantProfile = new AspirantProfile(requestData[1], requestData[2], requestData[3], requestData[4], requestData[5],
                    requestData[6], Date.valueOf(requestData[7]), requestData[8], requestData[9], requestData[10], requestData[11], requestData[12]);
            aspirantService.updateAspirantProfile(requestData[0], aspirantProfile);
        }

        java.util.Date currentDate = new java.util.Date();
        String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:s").format(currentDate);

        Resume resume = new Resume(Timestamp.valueOf(curStringDate), requestData[13], Boolean.valueOf(requestData[14]),
                Boolean.valueOf(requestData[15]), requestData[16], Float.valueOf(requestData[17]),0, aspirantService.getAspirantAccountByEmail(requestData[0]).getId());

        aspirantService.addAspirantResume(requestData[0], resume);
        return null;
    }
}
