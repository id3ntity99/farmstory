package farmstory.controller;

import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.DataAccessObject;
import farmstory.DefaultDAO;
import farmstory.DefaultService;
import farmstory.Service;
import farmstory.dto.UserDTO;
import farmstory.service.UserService;
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

  public Service<UserDTO> service;

  @Override
  public void init() throws ServletException {
    DataAccessObject<UserDTO> dao = new DefaultDAO<UserDTO>(new ConnectionHelper("jdbc/farmstory"));
    this.service = new DefaultService<>(dao);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Implement this method.
    UserService userService = (UserService) service; // FIXME 예제코드. DefaultService에 없는 User 테이블에 대한
                                                     // 특수한 쿼리를 사용해야할 경우에는 이처럼 형변환(casting)을 이용해
                                                     // DefaultService를 UserService로 바꿔 메서드를 사용한다.
    userService.join(); // FIXME 예제코드
  }
}
