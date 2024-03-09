package com.geektrust.backend.Commands;

import java.util.HashMap;
import java.util.List;

public class CommandInvoker {
    private final HashMap<String, Icommand> commandMap = new HashMap<>();

    public void register(String commandName, Icommand command) {
        commandMap.put(commandName, command);
    }

    public Icommand get(String commandName) {
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens) {
        Icommand command = get(commandName);
        if (command == null) {
            System.out.println("error");
        }
        command.execute(tokens);
    }

}
