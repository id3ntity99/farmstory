package farmstory.controller.user;

import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.CountableDefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignInController extends HttpServlet {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER = LoggerFactory.getLogger(SignInController.class.getName());

  private CountableDAO<UserDTO> dao;
  private CountableDefaultService<UserDTO> service;

  @Override
  public void init() throws ServletException {
    this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
    this.service = new CountableDefaultService<>(dao);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String password = req.getParameter("password");
    String name = req.getParameter("name");
    String nickname = req.getParameter("nickname");
    String email = req.getParameter("email");
    String phoneNum = req.getParameter("phone_num");
    String zip = req.getParameter("zip");
    String address = req.getParameter("address");
    UserDTO dto = new UserDTO();
    dto.setId(id);
    dto.setPassword(password);
    dto.setName(name);
    dto.setNickname(nickname);
    dto.setEmail(email);
    dto.setPhoneNum(phoneNum);
    dto.setZip(zip);
    dto.setAddress(address);
    try {
      int idCount = service.count();
      if (idCount > 0) {
        // TODO: Send errorneous response.
      }
      service.create(dto);
    } catch (DataAccessException e) {
      // TODO: Send 500 response.
    }
  }
}
