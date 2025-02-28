package farmstory.controller.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import farmstory.CountableDAO;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.service.CountableDefaultService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class.getName());

  private CountableDAO<UserDTO> dao;
  private CountableDefaultService<UserDTO> service;

  private String stringify(BufferedReader reader) {
    return reader.lines().collect(Collectors.joining());
  }

  private UserDTO toUser(JsonObject obj) {
    Map<String, JsonElement> jsonMap = obj.asMap();
    String id = jsonMap.get("id").getAsString();
    String password = jsonMap.get("password").getAsString();
    String name = jsonMap.get("name").getAsString();
    String nickname = jsonMap.get("nickname").getAsString();
    String email = jsonMap.get("email").getAsString();
    String phoneNum = jsonMap.get("phoneNum").getAsString();
    String zip = jsonMap.get("zip").getAsString();
    String address = jsonMap.get("address").getAsString();
    String addressDetail = jsonMap.get("addressDetail").getAsString();

    UserDTO dto = new UserDTO();
    dto.setId(id);
    dto.setPassword(password);
    dto.setName(name);
    dto.setNickname(nickname);
    dto.setEmail(email);
    dto.setPhoneNum(phoneNum);
    dto.setZip(zip);
    dto.setAddress(address);
    dto.setAddressDetail(addressDetail);

    return dto;
  }

  @Override
  public void init() throws ServletException {
    this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
    this.service = new CountableDefaultService<>(dao);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/register.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String jsonString = stringify(req.getReader());
    JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();
    try {
      int idCount = service.count();
      if (idCount > 0) {
        JsonObject json = new JsonObject();
        json.addProperty("isSuccess", false);
        json.addProperty("message", "Duplicate ID detected");
        resp.setStatus(HttpServletResponse.SC_CONFLICT);
        resp.setContentType("application/json");
        resp.getWriter().println(json);
      } else {
        UserDTO dto = toUser(obj);
        service.create(dto);
        resp.sendRedirect("/farmstory/signin");
      }
    } catch (DataAccessException | IOException e) {
      String msg = String.format("%s%n%s", e.getMessage(), e.getStackTrace());
      LOGGER.debug(msg);
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

  }
}
