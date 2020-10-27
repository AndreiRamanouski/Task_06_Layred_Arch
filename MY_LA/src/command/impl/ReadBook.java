package command.impl;

import java.util.ArrayList;
import java.util.List;

import Beans.Book;
import Beans.User;
import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.UpdateLibraryService;
import service.exception.ServiceException;

public class ReadBook implements Command {

	@Override
	public String execute(String request) throws CommandException {
		
		String[] str = request.split("\\s+");
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookservice = serviceFactory.getLibraryService();
		List<Book> books = new ArrayList<>();
		String res = "Viewing. ";
		
		try {
			books = bookservice.showLibrary(new User(str[1], str[2], str[3]));
			for (Book s : books) {
				System.out.println(s);
			}
		} catch (ServiceException e) {
			System.out.println(res);
			throw new CommandException("Somethinf went wrong");
		}
		
		
		
		return res;
	}

}
