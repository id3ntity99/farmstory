package farmstory.service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import farmstory.CountableDAO;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;

public class UserService extends CountableDefaultService<UserDTO>{

	private UserDAO userDAO;
	
	public UserService(UserDAO dao) {
		super((CountableDAO<UserDTO>) dao);
		this.userDAO = dao;
	}
  
	public UserDTO findUser(String name, String email) {
		return userDAO.findUser(name, email);
	}
	public List<UserDTO> findResult(){
		return userDAO.selectResult();
	}
}
