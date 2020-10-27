package command.impl;

import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.UserService;
import service.exception.ServiceException;

public class Logination implements Command{

	@Override
	public String execute(String request) throws CommandException {
		
		String[] str = request.split("\\s+");
		String res = "Logination. ";
		String login = str [1];
		String password = str [2];
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();
		
		try {
			if(userservice.logination(login, password)) {
			res += "Success";
			}
		} catch (ServiceException e) {
			throw new CommandException("Couldn't complete logination");
		}
		
		
		return res;
	}

}
