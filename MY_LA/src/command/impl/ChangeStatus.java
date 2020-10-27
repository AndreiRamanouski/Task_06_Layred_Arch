package command.impl;

import Beans.User;
import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.UserService;
import service.exception.ServiceException;

public class ChangeStatus implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String[] str = request.split("\\s+");
		String res = "Changing access. ";
		
		User user = new User(str [1],str [2]);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();
		
		try {
			if(userservice.changeStatus(user)) {
			res += "Success";
			}
		} catch (ServiceException e) {
			throw new CommandException("Couldn't complete access changing");
		}
		
		return res;
	}

}
