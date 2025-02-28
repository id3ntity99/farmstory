package farmstory.util;

import com.google.gson.JsonObject;
import farmstory.exception.InvalidUserInformationException;
import farmstory.exception.PasswordConfirmException;

public class InputValidator {
  public static final String ID_REGEX = "^[a-z]+[a-z0-9]{4,19}$";
  public static final String PASSWORD_REGEX =
      "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{5,16}$";
  public static final String NAME_REGEX = "^[가-힣]{2,10}$";
  public static final String NICKNAME_REGEX = "^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$";
  public static final String EMAIL_REGEX =
      "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
  public static final String PHONE_NUM_REGEX = "^01(?:0|1|[6-9])-(?:\\d{4})-\\d{4}$";
  public static final String ZIP_REGEX = "(\\d{3}-\\d{3}|\\d{5})";
  public static final String ADDR_REGEX =
      "(([가-힣A-Za-z·\\d~\\-\\.]{2,}(로|길).[\\d]+)|([가-힣A-Za-z·\\d~\\-\\.]+(읍|동)\\s)[\\d]+)";
  public static final String ADDR_DETAIL_REGEX = "^[가-힣0-9\\\\s]+$";
  private final JsonObject obj;

  public InputValidator(JsonObject obj) {
    this.obj = obj;
  }

  public void validate(String key, String regex) throws InvalidUserInformationException {
    String value = obj.asMap().get(key).getAsString();
    if (!value.matches(regex)) {
      String message = String.format("유효하지 않은 \"%s\" 데이터 \"%s\"입니다.", key, value);
      throw new InvalidUserInformationException(message);
    }
  }

  public void confirmPassword() throws PasswordConfirmException {
    String password = obj.asMap().get("password").getAsString();
    String passwordConfirm = obj.asMap().get("passwordConfirm").getAsString();

    if (!password.equals(passwordConfirm))
      throw new PasswordConfirmException("비밀번호가 일치하지 않습니다");
  }
}
