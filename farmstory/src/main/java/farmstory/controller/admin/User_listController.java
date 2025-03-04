package farmstory.controller.admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.dao.UserDAO;
import farmstory.dto.OrderDTO;
import farmstory.dto.UserDTO;
import farmstory.service.CountableDefaultService;
<<<<<<< HEAD
import farmstory.service.DefaultService;
=======
import farmstory.service.CountableService;
>>>>>>> 11864a6bba3f6afd8d0d0dcb37d9dca978cab7f5
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
    private static final Logger logger = LoggerFactory.getLogger(User_listController.class.getName());

<<<<<<< HEAD
    private DefaultService<UserDTO> service;
=======
	private CountableService<UserDTO> service;
>>>>>>> 11864a6bba3f6afd8d0d0dcb37d9dca978cab7f5

    @Override
    public void init() throws ServletException {
        try {
            ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
            UserDAO dao = new UserDAO(helper);
            // CountableDefaultService에 UserDTO 타입을 명확히 지정
            this.service = new DefaultService<UserDTO>(dao);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<UserDTO> users = service.getAll();

            String pg = req.getParameter("pg");
            int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;

            int pageSize = 10; // 한 페이지에 보여줄 데이터 수
            int total = users.size(); // 전체 데이터 개수
            int lastPageNum = (int) Math.ceil((double) total / pageSize); // 마지막 페이지 번호 계산

            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total); // 페이지 마지막 인덱스

            List<UserDTO> currentPageUsers = users.subList(startIndex, endIndex);

            req.setAttribute("articles", currentPageUsers);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("lastPageNum", lastPageNum);

            int startPage = ((currentPage - 1) / 5) * 5 + 1;
            int endPage = Math.min(startPage + 4, lastPageNum);
            req.setAttribute("startPage", startPage);
            req.setAttribute("endPage", endPage);

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
