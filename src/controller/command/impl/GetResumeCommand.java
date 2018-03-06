package controller.command.impl;

import controller.command.Command;
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
        String[] aspirantResume = request.split(";");
        AspirantResume resume = new AspirantResume("Крутой парень", Float.valueOf(1), "Иванов",
                "Иван", "Иванович" ,"Мужской", Date.valueOf("1998-05-10"), "user@gmail.com",
                "123123123", "Космотнавтов 11-130", "Минск","БГУИР",
                "A2", "Да", "Нет", "", "Я крут");
        //TODO: получить резюме
        return resume;
    }
}
