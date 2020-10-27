package dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Beans.User;
import dao.UserDao;
import dao.exception.DAOException;

public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean logination(String login, String password) throws DAOException {
		BufferedReader bstream = null; 
		String[] logination;
		Boolean operation = false;
		
		try {
			
			FileReader reader = new FileReader("C:\\Work\\ListOfUsers.txt");
			bstream = new BufferedReader(reader);
			String line = bstream.readLine();
			
			while (line!=null) {
				logination = line.split("\\s+");
					
				if (logination[0].equals(login) && logination[1].equals(password)) {
					
						operation = true;
						
				} if(operation) break;
			}
			if(operation) {
				System.out.println("Loogination completed");
			} else {
				throw new DAOException("User not found");
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {
			throw new DAOException("IOException", e);
		} finally {
				try {
				
					if (bstream != null) {
						bstream.close();
					}
				} catch (IOException e) {
					throw new DAOException("Cannot close", e);
				}
		}
		return operation;
	}
	
	
	@Override
	public boolean changeUser(User user, String status) throws DAOException {
		Boolean operation = false;
		BufferedReader bstream = null; 
		String[] change;
		
		try {
			FileReader reader = new FileReader("C:\\Work\\ListOfUsers.txt");
			bstream = new BufferedReader(reader);
			String line = bstream.readLine();
			
			while (line!=null) {
				change = line.split("\\s+");
					
				if (change[0].equals(user.getLogin())) {
						
					user.setSatus(status);
								
					}
				}
							
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {
			throw new DAOException("IOError", e);
		}  finally {
			try {
				if (bstream != null) {
					bstream.close();
					
					operation = true;
				}
			} catch (IOException e1) {
				throw new DAOException("IOCloseError", e1);
			}
			
		}
		return operation;
	}
		
	
	
	
	@Override
	public boolean registerUser(String login, String parol) throws DAOException {
		User user;
		Boolean operation = false;
			
			try {
				user = new User(login,parol);
				FileWriter writer = new FileWriter("C:\\Work\\ListOfUsers.txt", true);
				String registration = user.getLogin() + " " + user.getParol() + " " + user.getSatus();
				writer.write(registration + "\n");
				
				try {	
					if (!(writer == null)) {
						
						writer.close();
						
						operation = true;
					}
					
				} catch (IOException e) {
					throw new DAOException("IOCannotClose", e);
				}
				
			} catch (FileNotFoundException e) {
				
				throw new DAOException("FileNotFound", e);
				
			}catch (IOException e) {
				
				throw new DAOException("IOOpeningFile", e);
			}
			return operation;
		}


}
