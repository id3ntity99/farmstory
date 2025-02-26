package farmstory.util;

import farmstory.exception.InvalidUserInformationException;

public class InputValidator {
  public static final String ID_REGEX = "/^[a-z]+[a-z0-9]{4,19}$/g";
  public static final String PASSWORD_REGEX =
      "/^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{5,16}$/";
  public static final String NAME_REGEX = "^[가-힣]{2,10}$/";
  public static final String NICKNAME_REGEX = "/^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/";
  public static final String EMAIL_REGEX =
      "/^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$/i";
  public static final String PHONE_NUM_REGEX = "/^01(?:0|1|[6-9])-(?:\\d{4})-\\d{4}$/";
  public static final String ZIP_REGEX = "/(\\d{3}-\\d{3}|\\d{5})/";
  public static final String ADDR_REGEX = "/[가-힣 1-9\\-]+/g";

  public static void validate(String input, String regex) throws InvalidUserInformationException {
    if (input == null || !input.matches(regex)) {
      String message = String.format("Invalid user input detected: %s", input);
      throw new InvalidUserInformationException(message);
    }
  }

  private InputValidator() {
    // Empty constructor.
  }
}
