package farmstory.controller.my;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;
import farmstory.util.ResponseBodyWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/my/modifyInfo.do")
public class ModifyInfoController extends HttpServlet {

  private static final long serialVersionUID = 124512451231246L;
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  UserDAO dao;

  @Override
  public void init() throws ServletException {
    ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
    this.dao = new UserDAO(helper);
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();
    UserDTO sessionUser = (UserDTO) session.getAttribute("sessUser");

    if (sessionUser == null) {
      resp.sendRedirect("/farmstory/signin"); // ✅ 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
      return;
    }

    try {
      UserDTO user = dao.select(sessionUser);
      req.setAttribute("user", user);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/my/modify-info.jsp");
      dispatcher.forward(req, resp);
    } catch (DataAccessException e) {
      ResponseBodyWriter.write(false, "Internal Server Error",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR, resp);
    }
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");

    if (sessUser == null) {
      ResponseBodyWriter.write(false, "로그인이 필요합니다", HttpServletResponse.SC_FORBIDDEN, resp);
      return;
    }

    String id = sessUser.getId();

    String action = req.getParameter("action");

    try {
      if ("update".equals(action)) {
        UserDTO user = dao.select(sessUser);
        user.setPassword(req.getParameter("password").isEmpty() ? user.getPassword()
            : req.getParameter("password"));
        user.setName(
            req.getParameter("name").isEmpty() ? user.getName() : req.getParameter("name"));
        user.setNickname(req.getParameter("nickname").isEmpty() ? user.getNickname()
            : req.getParameter("nickname"));
        user.setPhoneNum(
            req.getParameter("phone").isEmpty() ? user.getPhoneNum() : req.getParameter("phone"));
        user.setEmail(
            req.getParameter("email").isEmpty() ? user.getEmail() : req.getParameter("email"));
        user.setAddress(req.getParameter("address").isEmpty() ? user.getAddress()
            : req.getParameter("address"));
        user.setAddressDetail(req.getParameter("detailAddress").isEmpty() ? user.getAddressDetail()
            : req.getParameter("detailAddress"));

        logger.debug("action : " + action);

        dao.update(user);
      } else if ("delete".equals(action)) {
        dao.deleteUser(id);
        dao.delete(sessUser);
        session.removeAttribute("sessUser");
        session.invalidate();
        resp.sendRedirect("/farmstory/index.do");
      }
      ResponseBodyWriter.write(true, "", HttpServletResponse.SC_OK, resp);
    } catch (DataAccessException e) {
      logger.error("", e);
      ResponseBodyWriter.write(false, "Internal Server Error",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR, resp);
    }

  }
}


