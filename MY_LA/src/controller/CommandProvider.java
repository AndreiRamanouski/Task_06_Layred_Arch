package controller;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import command.exception.CommandException;
import command.impl.AddNewBook;
import command.impl.ChangeStatus;
import command.impl.Logination;
import command.impl.ReadBook;
import command.impl.Registration;



final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
		commands.put("READ_ALL_BOOKS", new ReadBook());
		commands.put("READ_ALL_BOOKS", new ChangeStatus());
	}

	Command getCommand(String commandName) throws CommandException {
		Command command = commands.get(commandName);
		if (command == null) {
			throw new CommandException("Incorrect command");
		}
		return command;
	}

}
