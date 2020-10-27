package service.impl;

import java.util.List;

import Beans.Book;
import Beans.User;
import dao.DAOFactory;
import dao.exception.DAOException;
import service.UpdateLibraryService;
import service.exception.ServiceException;



public class UpdateLibraryServiceImpl implements UpdateLibraryService {
	DAOFactory daoFactory = DAOFactory.getInstance();
	

	@Override
	public List<Book> showLibrary(User user) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Book> books;
		
		try {
			books = daoFactory.getBookDAO().showBooks(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return books;
		
		
	}

	@Override
	public boolean addNewBook(String title, String author, String status) throws ServiceException {
		boolean ar = false;
		Book book = new Book( title, author);
		
		try {
			ar = daoFactory.getBookDAO().addBook(book, status);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return ar;
	}

	

}
