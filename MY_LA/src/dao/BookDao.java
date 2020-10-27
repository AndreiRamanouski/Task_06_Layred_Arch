
package dao;

import java.util.List;

import Beans.Book;
import Beans.User;
import dao.exception.DAOException;

public interface BookDao {
	
	boolean addBook(Book book, String status) throws DAOException;
	List<Book> showBooks(User user) throws DAOException;

}
