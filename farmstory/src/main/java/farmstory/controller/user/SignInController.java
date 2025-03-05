package farmstory.controller.user;

import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import farmstory.DataAccessObject;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.DefaultService;
import farmstory.service.Service;
import farmstory.util.ConnectionHelper;
import farmstory.util.ResponseBodyWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class SignInController extends HttpServlet {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER = LoggerFactory.getLogger(SignInController.class.getName());

  private Service<UserDTO> service;

  @Override
  public void init() throws ServletException {
    ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
    DataAccessObject<UserDTO> dao = new UserDAO(helper);
    service = new DefaultService<>(dao);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/login.jsp");
    dispatcher.forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    JsonObject json = JsonParser.parseReader(req.getReader()).getAsJsonObject();

    String id = json.get("id").getAsString();
    String password = json.get("password").getAsString();

    UserDTO dto = new UserDTO();
    dto.setId(id);
    dto.setPassword(password);


    try {
      UserDTO result = service.get(dto);

      if (result.getId() == null) {
        ResponseBodyWriter.write(false, "존재하지 않는 계정입니다.", HttpServletResponse.SC_NOT_FOUND, resp);
        return;
      }

      if (!result.getPassword().equals(password)) {// 비밀번호가 일치하지 않는 경우
        ResponseBodyWriter.write(false, "비밀번호가 일치하지 않습니다.", HttpServletResponse.SC_BAD_REQUEST,
            resp);
      } else {
        resp.sendRedirect("/farmstory/index.jsp");
      }

    } catch (DataAccessException e) {
      LOGGER.error("사용자 로그인 검증 중 예외가 발생하였습니다.", e);
      ResponseBodyWriter.write(false, "Internal Server Error",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR, resp);
    }
  }
}
