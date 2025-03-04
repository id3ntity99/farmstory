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
	private DataAccessObject ProductDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product-enroll.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		int price = Integer.parseInt(req.getParameter("price"));
        int point = Integer.parseInt(req.getParameter("point"));
        int discountRate = Integer.parseInt(req.getParameter("discountRate"));
		int deliveryFee = Integer.parseInt(req.getParameter("deliveryFee"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		int imageId = Integer.parseInt(req.getParameter("imageId"));
		String registerDate = req.getParameter("registerDate");
		
		ProductDTO dto = new ProductDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setPrice(price);
		dto.setPoint(point);
		dto.setDiscountRate(discountRate);
		dto.setDeliveryFee(deliveryFee);
		dto.setStock(stock);
		dto.setImageId(imageId);
		dto.setRegisterDate(registerDate);	
		
		DefaultService<ProductDTO> productService = new DefaultService(ProductDAO);
		try {
			productService.create(dto);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/farmstory/admin/product-list.do");
	}

}
