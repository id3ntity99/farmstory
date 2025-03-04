package farmstory.controller.admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.dao.UserDAO;
import farmstory.dto.OrderDTO;
import farmstory.dto.UserDTO;
import farmstory.service.CountableDefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/user-list.do")
public class User_listController extends HttpServlet {

	private static final long serialVersionUID = -4296729693079948400L;
	private static final Logger logger = LoggerFactory.getLogger(Order_listController.class.getName());

	private CountableDefaultService<UserDTO> service;

	@Override
	public void init() throws ServletException {
		try {
			ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
			UserDAO dao = new UserDAO(helper);
			this.service = new CountableDefaultService<>(dao);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 현재 페이지 계산
			String pg = req.getParameter("pg");
			int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
			int pageSize = 10; // 페이지당 표시할 데이터 수
			int offset = (currentPage - 1) * pageSize; // SQL에서 사용할 offset 값

			// 주문 데이터 가져오기
			List<UserDTO> users = service.getAll();

			// 총 데이터 개수 가져오기
			int total = service.count();
			int lastPageNum = (int) Math.ceil((double) total / pageSize); // 마지막 페이지 번호 계산

			// 시작 페이지와 끝 페이지 계산 (페이징 그룹)
			int startPage = ((currentPage - 1) / 10) * 10 + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + 9, lastPageNum); // 끝 페이지 번호, lastPageNum을 넘지 않도록 처리
			
			req.setAttribute("articles", users);
			req.setAttribute("currentPage", currentPage); // 현재 페이지
			req.setAttribute("lastPageNum", lastPageNum); // 마지막 페이지 번호
			req.setAttribute("startPage", startPage); // 시작 페이지
			req.setAttribute("endPage", endPage); // 끝 페이지

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/user-list.jsp");
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			logger.error("게시글 목록 조회 중 오류 발생", e);
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "서버 오류 발생");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
