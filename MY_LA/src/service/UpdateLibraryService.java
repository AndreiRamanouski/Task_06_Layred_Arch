package service;

import java.util.List;

import Beans.Book;
import Beans.User;
import service.exception.ServiceException;

public interface UpdateLibraryService {
	boolean addNewBook(String title, String author, String access) throws ServiceException;
	List<Book> showLibrary(User user) throws ServiceException;
}
