package controller.command.impl;

import controller.command.Command;
import service.CompanyService;
import service.ServiceFactory;
import service.exception.*;

/**
 * Represents a company get command.
 */
public class GetCompanyCommand implements Command {

    private final CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException {

        return companyService.getCompanyByName(request);
    }
}
