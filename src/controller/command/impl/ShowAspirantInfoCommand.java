package controller.command.impl;

import controller.command.Command;
import domain.AspirantAccount;
import service.AspirantService;
import service.exception.ServiceException;
import service.impl.MyAspirantService;
import viewModel.Aspirant;
import service.ServiceFactory;

/**
 * Represents a command that gets aspirant information
 */
public class ShowAspirantInfoCommand implements Command {

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) {
        Aspirant aspirant = null;

        try {

            AspirantAccount aspirantAccount = aspirantService.getAspirantAccountByEmail(request);

            aspirant = new Aspirant(aspirantAccount.getAspirantProfile().getName(),
                    aspirantAccount.getAspirantProfile().getSurname(),
                    aspirantAccount.getAspirantProfile().getPatronymic(),
                    aspirantAccount.getAspirantProfile().getSex(),
                    aspirantAccount.getAspirantProfile().getEducation(),
                    aspirantAccount.getAspirantProfile().getDateOfBirth(),
                    aspirantAccount.getAspirantProfile().getPhoneNumber(),
                    aspirantAccount.getEmail(),
                    aspirantAccount.getAspirantProfile().getMailingAddress(),
                    aspirantAccount.getAspirantProfile().getEnglishLevel(),
                    aspirantAccount.getAspirantProfile().getAboutMe(),
                    aspirantAccount.getAspirantProfile().getCityOfResidence());

        } catch (ServiceException e) {
            //TODO: разобраться, куда девать эксепшены
            e.printStackTrace();
        }

        return aspirant;
    }
}
