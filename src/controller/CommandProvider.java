package controller;

import controller.command.Command;
import controller.command.impl.MyCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a class supplying commands.
 */
class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    /**
     * Initializes a new instance of the {@link CommandProvider}.
     */
    CommandProvider() {
        commands.put("my_command", new MyCommand());
    }

    /**
     * Returns the command corresponding to the commandName.
     * @param commandName command name.
     * @return command corresponding to the commandName or
     * {@code null} if command does not exist.
     */
    Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
