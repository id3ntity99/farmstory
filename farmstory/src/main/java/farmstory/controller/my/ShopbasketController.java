package farmstory.controller.my;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.CountableDAO;
import farmstory.controller.user.SignUpController;
import farmstory.dao.OrderDAO;
import farmstory.dto.OrderDTO;
import farmstory.service.CountableDefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/my/shopbasket.do")
public class ShopbasketController extends HttpServlet{

	private static final long serialVersionUID = 124541245425112446L;
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class.getName());
	
	CountableDAO<OrderDTO> dao;
	CountableDefaultService<OrderDTO> service;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.dao = new OrderDAO(new ConnectionHelper("jdbc/farmstory"));
		this.service = new CountableDefaultService<OrderDTO>(dao);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		if(userId == null) {
			resp.sendRedirect(req.getContextPath() + "/user/login.do");
			return;
		}
		
		List<OrderDTO> basketList = ((OrderDAO) dao).selectAll();
		req.setAttribute("basketList", basketList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/my/shopbasket.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		
		if (userId == null) {
			resp.sendRedirect(req.getContextPath() + "/user/login.do");
			return;
		}
		
		OrderDAO orderDAO = (OrderDAO) dao;
		
		switch (action) {
			
		case"update":
			int orderId = Integer.parseInt(req.getParameter("orderId"));
			int amount = Integer.parseInt(req.getParameter("amount"));
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(orderId);
			orderDTO.setAmount(amount);
			orderDAO.update(orderDTO);
			break;
			
		case"delete":
			int deleteId = Integer.parseInt(req.getParameter("orderId"));
			OrderDTO deleteorderDTO = new OrderDTO();
			deleteorderDTO.setId(deleteId);
			orderDAO.delete(deleteorderDTO);
			break;
			
		case"order":
			orderDAO.placeOrder(userId);
			break;
		}
		resp.sendRedirect(req.getContextPath() + "/my/shopbasket.do");
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
