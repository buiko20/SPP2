package controller;

import controller.command.Command;
import controller.command.impl.*;
import controller.command.impl.GetCompanyCommand;
import controller.command.impl.InvitationCommands.GetInvitationCommand;
import controller.command.impl.InvitationCommands.GetInvitationListForAspirantCommand;
import controller.command.impl.InvitationCommands.GetInvitationListForHRManager;
import controller.command.impl.InvitationCommands.SendInvitationCommand;
import controller.command.impl.JobVacancyCommands.*;
import controller.command.impl.ResumeCommands.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a class supplying commands.
 */
public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    /**
     * Initializes a new instance of the {@link CommandProvider}.
     */
    public CommandProvider() {
        addCommand(new RegisterAspirantCommand(), "Register");
        addCommand(new LoginAspirantCommand(), "Login");

        addCommand(new GetResumeListForAspirantCommand(), "GetResumeListForAspirant");
        addCommand(new GetResumeListForHRManagerCommand(), "GetResumeListForHRManager");

        addCommand(new CreateResumeCommand(), "CreateResume");
        addCommand(new GetResumeCommand(), "GetResume");
        addCommand(new UpdateResumeCommand(), "UpdateResume");
        addCommand(new DeleteResumeCommand(), "DeleteResume");
        addCommand(new UpdateResumeDateCommand(), "UpdateResumeDate");
        addCommand(new GetResumeViewListCommand(), "GetResumeViewList");

        addCommand(new GetJobVacancyListForHRManagerCommand(), "GetJobVacancyListForHRManager");
        addCommand(new GetJobVacancyListForAspirant(), "GetJobVacancyListForAspirant");

        addCommand(new CreateJobVacancyCommand(), "CreateJobVacancy");
        addCommand(new GetJobVacancyCommand(), "GetJobVacancy");
        addCommand(new UpdateJobVacancyCommand(), "UpdateJobVacancy");
        addCommand(new DeleteJobVacancyCommand(), "DeleteJobVacancy");

        addCommand(new GetCompanyCommand(), "GetCompany");

        addCommand(new GetInvitationCommand(), "GetInvitation");
        addCommand(new SendInvitationCommand(), "SendInvitation");

        addCommand(new GetInvitationListForHRManager(), "GetInvitationListForHRManager");
        addCommand(new GetInvitationListForAspirantCommand(), "GetInvitationListForAspirant");
    }

    /**
     * Adds the mapping of the command and command name
     * @param command command
     * @param commandName command name
     */
    private void addCommand(Command command, String commandName){
        commands.put(commandName, command);
    }

    /**
     * Returns the command corresponding to the commandName.
     * @param commandName command name.
     * @return command corresponding to the commandName or
     * {@code null} if command does not exist.
     */
    public Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
