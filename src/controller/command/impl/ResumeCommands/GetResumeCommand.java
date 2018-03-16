package controller.command.impl.ResumeCommands;

import controller.command.Command;
import domain.AspirantProfile;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;
import viewModel.AspirantResume;

import java.sql.Date;

/**
 * Represents a resume get command.
 */
public class GetResumeCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, HRManagerNotFoundException, ResumeNotFoundException {

        String[] requestData = request.split(";");

        String aspirantEmail = "";

        if(requestData.length != 2) {

            aspirantEmail = aspirantService.getAspirantAccountById(Integer.parseInt(requestData[0])).getEmail();

            requestData[0] = aspirantEmail;

            aspirantService.addAspirantResumeView(requestData[0], requestData[1], requestData[2]);
        }

        Resume resume = aspirantService.getAspirantResume(requestData[0], requestData[1]);
        AspirantProfile aspirantProfile = aspirantService.getAspirantProfile(requestData[0]);

        String isTripPossible, isRelocationPossible;

        if(resume.getTripPossible())
            isTripPossible = "Да";
        else
            isTripPossible = "Нет";

        if(resume.getRelocationPossible())
            isRelocationPossible = "Да";
        else
            isRelocationPossible = "Нет";

        AspirantResume aspirantResume = new AspirantResume(resume.getCareerObjective(), resume.getSalary(),
                aspirantProfile.getSurname(), aspirantProfile.getName(), aspirantProfile.getPatronymic() ,
                aspirantProfile.getSex(), aspirantProfile.getDateOfBirth(), aspirantProfile.getEmail(),
                aspirantProfile.getPhoneNumber(), aspirantProfile.getMailingAddress(), aspirantProfile.getCityOfResidence(),
                aspirantProfile.getEducation(), aspirantProfile.getEnglishLevel(), isTripPossible, isRelocationPossible,
                resume.getSkills(), aspirantProfile.getAboutMe());

        if(aspirantEmail != "")
            aspirantResume.accountEmail = aspirantEmail;

        return aspirantResume;
    }
}
