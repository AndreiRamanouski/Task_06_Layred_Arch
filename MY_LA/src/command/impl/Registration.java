package command.impl;


import Beans.User;
import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.UserService;
import service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String[] reques = request.split("\\s+");
		User user = new User(reques[1], reques[2]);
		
		String response = "Registring. ";
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();
		
		try {
			if(userservice.registration(user)) {
				response += "You registered";}
			
			else {
				throw new CommandException("Couldnt register");
				}
		} catch (ServiceException e) {
			throw new CommandException("Couldnt register");
		}
		return response;
	}

}
