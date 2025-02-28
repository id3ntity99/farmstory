package farmstory.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.CountableDAO;
import farmstory.DataAccessObject;
import farmstory.dao.ArticleDAO;
import farmstory.dto.ArticleDTO;
import farmstory.service.CountableDefaultService;
import farmstory.service.DefaultService;
import farmstory.service.Service;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listStory")
public class ListControllerStory extends HttpServlet {

	private static final long serialVersionUID = -6857925625588561308L;
    private static final Logger logger = LoggerFactory.getLogger(ListControllerStory.class.getName());

    private Service<ArticleDTO> service;
    
    @Override
    public void init() throws ServletException {
    	try {
    		// 1. DB 연결을 위한 ConnectionHelper 생성
            ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
            
            // 2. ArticleDAO 생성 후 DefaultService에 주입
            DataAccessObject<ArticleDTO> dao = new ArticleDAO(helper);
            this.service = new DefaultService<>(dao);
    	}catch (Exception e) {
			logger.error(e.getMessage());
		}
    }
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

            List<ArticleDTO> articles = service.getAll();

            String pg = req.getParameter("pg");
            
            int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
            
            int total = service.getAll().size(); // 전체 게시글 개수 가져오기
            
            int pageSize = 10; // 한 페이지당 보여줄 게시글 개수
            
            int lastPageNum = (int) Math.ceil((double) total / pageSize);
            
            req.setAttribute("articles", articles);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("lastPageNum", lastPageNum);


            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/story/storyList.jsp");
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