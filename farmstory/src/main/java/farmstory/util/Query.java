package farmstory.util;

public final class Query {
  public static final String INSERT_USER =
      "INSERT INTO `User` VALUES(?,?,?,?,0,0,?,?,?,?,?,NOW(),NULL);";

  private Query() {
    // Empty constructor
  }
}
