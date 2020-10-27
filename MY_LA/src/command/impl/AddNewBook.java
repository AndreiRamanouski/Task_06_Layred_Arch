package command.impl;

import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.UpdateLibraryService;
import service.exception.ServiceException;

public class AddNewBook implements Command{

	@Override
	public String execute(String request) throws CommandException {
		String[] str = request.split("\\s+");
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookservice = serviceFactory.getLibraryService();
		String res = "Adding a new book. ";
		
		try {
			if(bookservice.addNewBook(str[1], str[2], str[3])) {
				res += "The book has been added successfully!";
			}
		} catch (ServiceException e) {
			System.out.println(res);
			throw new CommandException("The book could not be added") ;
		}
		
		return res;
	}

}
