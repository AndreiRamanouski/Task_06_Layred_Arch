package service;

import service.impl.UpdateLibraryServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UpdateLibraryService updateLiraryService = new UpdateLibraryServiceImpl();
	private final UserService userService = new UserServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public UpdateLibraryService getLibraryService() {
		return updateLiraryService;
	}

}
