package farmstory.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class ConnectionHelper {
  private String farmstory;

  public ConnectionHelper(String farmstory) {
    this.farmstory = farmstory;
  }

  public Connection getConnection() throws SQLException, NamingException {
    Context ctx = (Context) new InitialContext().lookup("java:comp/env");
    DataSource ds = (DataSource) ctx.lookup("jdbc/farmstory");
    return ds.getConnection();
  }
}
