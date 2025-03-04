package farmstory.controller.admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.dao.OrderDAO;
import farmstory.dto.OrderDTO;
import farmstory.dto.ProductDTO;
import farmstory.dto.UserDTO;
import farmstory.service.CountableDefaultService;
import farmstory.service.DefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/main.do")
public class MainController extends HttpServlet{

	private static final long serialVersionUID = 1574381268514961003L;
	private static final Logger logger = LoggerFactory.getLogger(MainController.class.getName());
	private CountableDefaultService<OrderDTO> orderservice;
	private CountableDefaultService<ProductDTO> productservice;
	private CountableDefaultService<UserDTO> userservice;
	
	
	@Override
	public void init() throws ServletException {
		try {
            ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
            OrderDAO dao = new OrderDAO(helper);
            this.orderservice = new CountableDefaultService<>(dao);
    	}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
