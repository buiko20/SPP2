package controller.command.impl;

import controller.command.Command;
import domain.AspirantAccount;
import service.AspirantService;
import service.ServiceFactory;

public class RegisterAspirantCommand implements Command{

    private final AspirantService aspirantService = ServiceFactory.getInstance().getAspirantService();

    @Override
    public Object execute(String request) {
        try {
            String[] aspirant = request.split(";");
            AspirantAccount aspirantAccount = new AspirantAccount(aspirant[0], aspirant[1], null);
            aspirantService.register(aspirantAccount);
        }
        catch (Exception exception) {//TODO: разобраться с эксепшионами
        }
        return null;
    }
}
