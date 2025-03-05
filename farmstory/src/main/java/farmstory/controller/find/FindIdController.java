package farmstory.controller.find;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.sql.SQLException;

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
	    this.service = new UserService(dao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/find/find-id.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트로부터 전달받은 데이터 (이름, 이메일)
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        
        // 응답을 JSON 형태로 설정
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        try {
            UserDTO user = service.findUser(name, email);
            if (user != null) {
                // 인증번호 요청 및 처리 로직 호출 (EmailAuthController)
                out.write("{\"success\": true}");
            } else {
                out.write("{\"success\": false}");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            out.write("{\"success\": false}");
        } finally {
            out.close();
        }
    }
}
