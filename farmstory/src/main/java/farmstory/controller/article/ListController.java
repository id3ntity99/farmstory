package farmstory.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import farmstory.CountableDAO;
import farmstory.dao.ArticleDAO;
import farmstory.dto.ArticleDTO;
import farmstory.service.CountableDefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListController extends HttpServlet {

	private static final long serialVersionUID = -6857825625588561308L;
	private static final Logger logger = LoggerFactory.getLogger(ListController.class.getName());
	
	private CountableDAO<ArticleDTO> dao;
	private CountableDefaultService<ArticleDTO> service;

	
	@Override
	public void init() throws ServletException {
		this.dao = new ArticleDAO(new ConnectionHelper("jdbc/farmstory"));
		this.service = new CountableDefaultService<>(dao);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pg = req.getParameter("pg");
		int total = dao.count(); 
		int lastPageNum = 
		
		List<ArticleDTO> articles = dao.selectAll();
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
