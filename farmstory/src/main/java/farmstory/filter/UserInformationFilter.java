package farmstory.filter;

import java.io.IOException;
import java.util.UUID;
import farmstory.exception.InvalidUserInformationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/signup", "/user/change"})
public class UserInformationFilter extends HttpFilter {
  private static final long serialVersionUID = UUID.randomUUID().version();

  private void validate(String info, String regex) throws InvalidUserInformationException {
    if (info != null && !info.matches(regex)) {
      String message =
          String.format("Invalid user input detected: %s\n Redirecting to sign-in page", info);
      throw new InvalidUserInformationException(message);
    }
  }

  private void nullableValidate(String info, String regex) {}

  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String nickName = request.getParameter("nickname");
    String email = request.getParameter("email");
    String phoneNumber = request.getParameter("phone_num");
    String zip = request.getParameter("zip");
    String address = request.getParameter("address");

    try {
      validate(id, ValidInputRegex.ID_REGEX);
      validate(password, ValidInputRegex.PASSWORD_REGEX);
      validate(name, ValidInputRegex.NAME_REGEX);
      validate(nickName, ValidInputRegex.NICKNAME_REGEX);
      validate(email, ValidInputRegex.EMAIL_REGEX);
      validate(phoneNumber, ValidInputRegex.PHONE_NUM_REGEX);
      validate(zip, ValidInputRegex.ZIP_REGEX);
      validate(address, ValidInputRegex.ADDR_REGEX);
      RequestDispatcher ds = request.getRequestDispatcher("/");
    } catch (InvalidUserInformationException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input detected");
    }
  }
}
