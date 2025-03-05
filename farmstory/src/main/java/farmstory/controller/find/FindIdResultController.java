package farmstory.controller.find;

import java.io.IOException;
import java.util.List;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.UserService;
import farmstory.util.ConnectionHelper;
import farmstory.util.ResponseBodyWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/find/findIdResult.do")
public class FindIdResultController extends HttpServlet {

  private static final long serialVersionUID = 124541279112446L;
  private UserDAO dao;
  private UserService service;

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
    this.service = new UserService(dao);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      List<UserDTO> users = service.findResult();
      req.setAttribute("users", users);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/find/find-id-result.jsp");
      dispatcher.forward(req, resp);
    } catch (DataAccessException e) {
      ResponseBodyWriter.write(false, "Internal Server Error",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR, resp);
    }

  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

  }

}
