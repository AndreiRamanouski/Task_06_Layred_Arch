package service.impl;

import Beans.User;
import dao.DAOFactory;
import dao.UserDao;
import service.UserService;
import service.exception.ServiceException;
import dao.exception.DAOException;

public class UserServiceImpl implements UserService{

	

	@Override
	public boolean logination(String login, String password) throws ServiceException {
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		Boolean operation = false;
		try {
			if( userDAO.logination(login, password)) {
				operation = true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return operation;
	}

	@Override
	public boolean registration(User user) throws ServiceException {
		
		Boolean operation = false;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		try {
			if(userDAO.registerUser(user.getLogin(), user.getParol())){
				operation = true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return operation;
	}
	
	
	
	public boolean changeStatus(User user) throws ServiceException {
		Boolean operation = false;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		try {
			if(userDAO.changeUser(user, "adult")){
				operation = true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return operation;
		
	}
}
