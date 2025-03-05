package farmstory.util;

public final class Query {
  public static final String INSERT_USER =
      "INSERT INTO `user` VALUES(?,SHA2(?, 256),?,?,0,0,?,?,?,?,?,NOW(),NULL);";
  public static final String SELECT_USER = "SEELCT * FROM `user` WHERE `id` = ?;";
  public static final String SELECT_ALL_USER = "SELECT * FROM `user` WHERE;";
  public static final String COUNT_USER_WITH_COLNAME =
      "SELECT COUNT(?) FROM `user` WHERE `id` = ?;";
  public static final String COUNT_USER = "SELECT COUNT(`id`) FROM `user`;";
  public static final String UPDATE_USER =
      "UPDATE `user` SET `password`=?, `name`=?, `nickname`=?, `point`=?, `level`=?, `email`=?, `phone_num`=?, `zip`=?, `address`=?, `address_detail`=? WHERE `id`=?;";
  public static final String DELETE_USER = "DELETE FROM `user` WHERE `id`=?;";

  public static final String INSERT_TERM = "INSERT INTO `term` VALUES(?, ?, ?);";
  public static final String SELECT_TERM = "SEELCT * FROM `term` WHERE `id` = ?;";
  public static final String SELECT_ALL_TERMS = "SELECT * FROM `term`;";
  public static final String UPDATE_TERM = "UPDATE `term` SET `title`=? `content`=? WHERE `id`=?;";
  public static final String DELETE_TERM = "DELETE FROM `term` WHERE `id` = ?;";

  private Query() {
    // Empty constructor
  }
}
