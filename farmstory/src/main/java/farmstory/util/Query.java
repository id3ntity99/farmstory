package farmstory.util;

public final class Query {
  public static final String INSERT_USER =
      "INSERT INTO `user` VALUES(?,SHA2(?, 256),?,?,0,0,?,?,?,?,?,NOW(),NULL);";
  public static final String COUNT_USER = "SELECT COUNT(`?`) FROM `user` WHERE `id` = ?;";

  private Query() {
    // Empty constructor
  }
}
