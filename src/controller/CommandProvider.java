package controller;

import controller.command.Command;
import controller.command.impl.LoginAspirantCommand;
import controller.command.impl.RegisterAspirantCommand;

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
        addCommand(new RegisterAspirantCommand(), "Зарегистрироваться");
        addCommand(new LoginAspirantCommand(), "Выполнить вход");
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
