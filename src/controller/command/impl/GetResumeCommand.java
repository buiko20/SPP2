package controller.command.impl;

import controller.command.Command;
import domain.AspirantProfile;
import domain.Resume;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;
import viewModel.AspirantResume;

import java.sql.Date;

/**
 * Represents a resume getting command.
 */
public class GetResumeCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException {

        String[] requestData = request.split(";");

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

        return aspirantResume;
    }
}
