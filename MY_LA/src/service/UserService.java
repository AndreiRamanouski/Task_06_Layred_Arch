package service;


import Beans.User;
import service.exception.ServiceException;

public interface UserService {
	boolean logination(String login, String password) throws ServiceException;
	boolean registration(User user) throws ServiceException;
	boolean changeStatus(User user) throws ServiceException;
}
