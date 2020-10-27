package dao;

import Beans.User;
import dao.exception.DAOException;

public interface UserDao {

	boolean registerUser(String login, String parol) throws DAOException;
	boolean logination(String login, String password) throws DAOException;
	boolean changeUser(User user, String status) throws DAOException;
	
	
}
