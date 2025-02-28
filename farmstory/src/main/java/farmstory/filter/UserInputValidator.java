package farmstory.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import farmstory.exception.InvalidUserInformationException;
import farmstory.exception.PasswordConfirmException;
import farmstory.util.InputValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/signup"})
public class UserInputValidator extends HttpFilter {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER = LoggerFactory.getLogger(UserInputValidator.class.getName());

  private String stringify(BufferedReader reader) {
    return reader.lines().collect(Collectors.joining());
  }

  private boolean doNullCheck(JsonObject obj) {
    Set<Map.Entry<String, JsonElement>> set = obj.entrySet();
    for (Map.Entry<String, JsonElement> entry : set) {
      boolean isValueNull = entry.getValue().isJsonNull();
      if (isValueNull)
        return isValueNull;

    }
    return false;
  }

  private void validate(JsonObject obj)
      throws InvalidUserInformationException, PasswordConfirmException {
    InputValidator validator = new InputValidator(obj);
    validator.validate("id", InputValidator.ID_REGEX);
    validator.validate("password", InputValidator.PASSWORD_REGEX);
    validator.validate("passwordConfirm", InputValidator.PASSWORD_REGEX);
    validator.validate("name", InputValidator.NAME_REGEX);
    validator.validate("nickname", InputValidator.NICKNAME_REGEX);
    validator.validate("email", InputValidator.EMAIL_REGEX);
    validator.validate("phoneNum", InputValidator.PHONE_NUM_REGEX);
    validator.validate("zip", InputValidator.ZIP_REGEX);
    validator.validate("address", InputValidator.ADDR_REGEX);
    validator.validate("addressDetail", InputValidator.ADDR_REGEX);
    System.out.println(obj.asMap().get("addressDetail").getAsString());
    validator.confirmPassword();
  }

  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    if (request.getMethod().equalsIgnoreCase("post")) {
      // Parse JSON string to JSON object
      String jsonString = stringify(request.getReader());
      JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();

      // Iterate each property to check if there are null values;
      boolean nullValExists = doNullCheck(obj);
      if (nullValExists) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
      } else {
        // Validate user info data such as ID, password, etc.
        try {
          validate(obj);
          chain.doFilter(request, response);
        } catch (InvalidUserInformationException | PasswordConfirmException e) {
          LOGGER.warn(e.getMessage(), e);
          e.printStackTrace();
          response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
      }
    } else {
      chain.doFilter(request, response);
    }
  }
}
