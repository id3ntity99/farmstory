package farmstory.util;

public final class Query {
  public static final String INSERT_USER =
      "INSERT INTO `user` VALUES(?,SHA2(?, 256),?,?,0,0,?,?,?,?,?,NOW(),NULL);";
  public static final String COUNT_USER = "SELECT COUNT(?) FROM `user` WHERE `id` = ?;";

  public static final String INSERT_TERM = "INSERT INTO `Term` VALUES(?, ?, ?);";
  public static final String SELECT_TERM = "SEELCT * FROM `Term` WHERE `id` = ?;";
  public static final String SELECT_ALL_TERMS = "SELECT * FROM `Term`;";
  public static final String UPDATE_TERM = "UPDATE `Term` SET `title`=? `content`=? WHERE `id`=?;";
  public static final String DELETE_TERM = "DELETE FROM `Term` WHERE `id` = ?;";

  private Query() {
    // Empty constructor
  }
}
