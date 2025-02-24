package farmstory.controller;

import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.DataAccessException;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.service.CountableDefaultService;
import farmstory.service.CountableService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/info")
public class UserController extends HttpServlet {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

  private CountableDAO<UserDTO> dao;
  private CountableService<UserDTO> service;

  @Override
  public void init() throws ServletException {
    ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
    dao = new UserDAO(helper);
    service = new CountableDefaultService<>(dao);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try { // 예제 코드
      UserDTO target = new UserDTO();
      // target.setUid("abc123");
      UserDTO dto = dao.select(target);
    } catch (DataAccessException e) {
      // TODO: handle exception
    }
  }
}
