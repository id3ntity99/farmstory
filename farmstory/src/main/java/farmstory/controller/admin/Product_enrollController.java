package farmstory.controller.admin;

import java.io.IOException;

import farmstory.DataAccessObject;
import farmstory.dao.ProductDAO;
import farmstory.dto.ProductDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.DefaultService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product-enroll.do")
public class Product_enrollController extends HttpServlet{

	private static final long serialVersionUID = 587656470097925202L;
	private ProductDAO productDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product-enroll.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.sendRedirect("/farmstory/admin/product-list.do");
	}

}
