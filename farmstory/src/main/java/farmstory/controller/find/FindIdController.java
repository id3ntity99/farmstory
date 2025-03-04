package farmstory.controller.find;

import java.io.IOException;

import farmstory.CountableDAO;
import farmstory.dao.OrderDAO;
import farmstory.dao.UserDAO;
import farmstory.dto.OrderDTO;
import farmstory.dto.UserDTO;
import farmstory.service.CountableDefaultService;
import farmstory.service.UserService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/find/findId.do")
public class FindIdController extends HttpServlet{

	private static final long serialVersionUID = 124541214445412446L;
	
	private UserDAO dao;
	private UserService service;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
		this.service = new UserService(this.dao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//viewpost
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/find/find-id.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		
        UserDTO user = dao.findUser(name, email);

        if (user != null) {
            req.setAttribute("userId", user.getId());
            req.getRequestDispatcher("/user/find_id_result.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "일치하는 회원 정보가 없습니다.");
            req.getRequestDispatcher("/user/find_id.jsp").forward(req, resp);
        }
    }
}
