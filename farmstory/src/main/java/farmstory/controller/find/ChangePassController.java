package farmstory.controller.find;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonObject;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.service.DefaultService;
import farmstory.service.Service;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/find/changePass.do")
public class ChangePassController extends HttpServlet {

  private static final long serialVersionUID = 124541214445412446L;
  private UserDAO dao;
  private Service<UserDTO> service;
  private Logger logger = LoggerFactory.getLogger(this.getClass());


  @Override
  public void init(ServletConfig config) throws ServletException {
    this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
    this.service = new DefaultService<>(dao);
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/find/change-pass.jsp");
    dispatcher.forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      // 변수명 통일: `userId`, `newPassword` 사용
      String userId = req.getParameter("userId");
      String newPassword = req.getParameter("newPassword");

      logger.debug("Received userId: {}", userId);
      logger.debug("Received newPassword: {}", newPassword);

      JsonObject json = new JsonObject();

      // 비밀번호 검증
      if (userId == null || newPassword == null || newPassword.trim().isEmpty()) {
        json.addProperty("status", "error");
        json.addProperty("message", "비밀번호를 입력해주세요.");
        resp.getWriter().write(json.toString());
        return;
      }

      // 비밀번호 변경 실행
      UserDTO target = new UserDTO();
      target.setId(userId);
      UserDTO user = service.get(target);
      user.setPassword(newPassword);
      dao.update(user);

      HttpSession session = req.getSession();
      session.removeAttribute("sessUser");
      session.invalidate();
      resp.sendRedirect("/farmstory/signin");
    } catch (Exception e) {
      logger.error("비밀번호 변경 중 오류 발생", e);
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }
}
