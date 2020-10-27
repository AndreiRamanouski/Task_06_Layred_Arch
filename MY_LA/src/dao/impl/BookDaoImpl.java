package dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Beans.Book;
import Beans.User;
import dao.BookDao;
import dao.exception.DAOException;


public class BookDaoImpl implements BookDao {
	
	@Override
	public List<Book> showBooks(User user) throws DAOException{
		BufferedReader bstream = null; 
		String[] show;
		Book book;
		List<Book> books = new ArrayList<Book>();
			try {
			
				FileReader reader = new FileReader("C:\\Work\\ListOfBooks.txt");
				bstream = new BufferedReader(reader);

				String line = bstream.readLine();
			
			
				if(user.getSatus().equals("junior")) {
					while (line!=null) {
						show = line.split("\\s+");
						book = new Book (show[0],show[1]);
						books.add(book);
				
					}
					return books;
					
				} else {
					while (line!=null) {
						show = line.split("\\s+");
						book = new Book (show[0],show[1]);
						books.add(book);
				
					}
					return books;
				}
			
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {
			throw new DAOException("IOException", e);
		} finally {
				try {
			
				if(bstream!=null) {
				bstream.close();
				
				}
			
				} catch (IOException e) {
					throw new DAOException("Cannot close", e);
				}
		}
	}

	@Override
	public boolean addBook(Book book, String status) throws DAOException {
		
		if (status.equals("adult") || status.equals("junior") ) {
			try {
				FileWriter writer = new FileWriter("C:\\Work\\ListOfBooks.txt", true);
				String addbook = book.getTitle() + " " +  book.getAuthor() + " " + status;
				writer.write(addbook + "\n");
				try {	
					if(writer!=null) {
					writer.close();
					}
				
				} catch (IOException e) {
					throw new DAOException("IOCannotClose", e);
				}
			
			} catch (FileNotFoundException e) {
			
				throw new DAOException("FileNotFound", e);
				
			} catch (IOException e) {
			
				throw new DAOException("IOOpeningFile", e);
			}
		} else {
		throw new DAOException("Choose apropriate status for the book");
		}
		return true;
		
	}

}
