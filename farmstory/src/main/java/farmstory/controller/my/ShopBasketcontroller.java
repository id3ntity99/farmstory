package farmstory.controller.my;

import java.io.IOException;

import farmstory.CountableDAO;
import farmstory.dao.OrderDAO;
import farmstory.dao.UserDAO;
import farmstory.dto.OrderDTO;
import farmstory.service.CountableDefaultService;
import farmstory.service.CountableService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/my/shopbasket.do")
public class ShopBasketcontroller extends HttpServlet {

	private static final long serialVersionUID = 11515121612L;
	
	private CountableDAO<OrderDTO> dao;
	private CountableService<OrderDTO> service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//View forward
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/my/shopbasket.jsp");
	    dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
