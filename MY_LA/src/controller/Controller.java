package controller;

import command.Command;
import command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request){
			String commandName;
			String[] mas = request.split("\\s+");
			commandName = mas[0];
			commandName = commandName.toUpperCase();

			String response;
			try {
				Command command = provider.getCommand(commandName);
				response = command.execute(request);
			} catch (CommandException e) {
				response = "Error";
			}
			return response;

		}
}
