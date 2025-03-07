package farmstory.controller.article;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.dao.ArticleDAO;
import farmstory.dto.ArticleDTO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.DefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/writeGardening")
@MultipartConfig
public class WriteControllerGardening extends HttpServlet {
  private static final long serialVersionUID = -8195103407449469536L;
  private static final Logger logger =
      LoggerFactory.getLogger(WriteControllerGardening.class.getName());

  private DefaultService<ArticleDTO> service;
  private DefaultService<ArticleDTO> fileService;

  @Override
  public void init() throws ServletException {
    try {
      ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
      ArticleDAO dao = new ArticleDAO(helper);
      this.service = new DefaultService<>(dao);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/story/gardeningWrite.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    UserDTO sessUser = (UserDTO) req.getSession().getAttribute("sessUser");
    try {
      if (sessUser != null) {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String author = req.getParameter("author");

        logger.info("Received data: title={}, content={}, author={}", title, content, author);

        ArticleDTO dto = new ArticleDTO();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setAuthor(author);
        dto.setUserId(sessUser.getId());
        service.create(dto);

        logger.debug(dto.toString());

        resp.sendRedirect(req.getContextPath() + "/listGardening");

      } else {
        resp.sendRedirect("/farmstory/signin");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage());
    }
  }
}
