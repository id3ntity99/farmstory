package farmstory.controller.find;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.service.UserService;
import farmstory.util.ConnectionHelper;
import farmstory.util.ResponseBodyWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/find/findPass.do")
public class FindPassController extends HttpServlet{

	private static final long serialVersionUID = 124541214445412446L;
	
	private UserDAO dao;
	private UserService service;
	
	@Override
	public void init() throws ServletException {
		this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
	    this.service = new UserService(dao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/find/find-pass.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		UserDTO user = dao.findPass(id, email);
		
	}
}


	
	
	
	
	
	
	
	
	
	


