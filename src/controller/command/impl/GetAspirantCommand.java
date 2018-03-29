package controller.command.impl;

import controller.command.Command;
import domain.AspirantAccount;
import domain.AspirantProfile;
import service.AspirantService;
import service.ServiceFactory;
import service.exception.*;
import viewModel.Aspirant;

/**
 * Represents an aspirant get command.
 */
public class GetAspirantCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException {

        AspirantAccount account = aspirantService.getAspirantAccountByEmail(request);
        AspirantProfile profile = aspirantService.getAspirantProfile(request);

        Aspirant aspirant = new Aspirant(profile.getName(), profile.getSurname(), profile.getPatronymic(),
                profile.getSex(), profile.getEducation(), profile.getDateOfBirth(), profile.getPhoneNumber(),
                account.getEmail(), profile.getMailingAddress(), profile.getEnglishLevel(), profile.getAboutMe(),
                profile.getCityOfResidence());

        return aspirant;
    }
}
