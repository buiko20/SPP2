package controller.command;

import service.exception.*;

/**
 * Represents a contract for a command pattern.
 */
public interface Command {

    /**
     * Execute a command
     * @param request param for command
     * @return result of the command work
     */
     Object execute(String request) throws AspirantAlreadyExistsException, ServiceException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ResumeNotFoundException, HRManagerNotFoundException, CompanyNotFoundException;

}
