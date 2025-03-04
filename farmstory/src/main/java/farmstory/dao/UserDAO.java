package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.UserDTO;
import farmstory.util.ConnectionHelper;

public class UserDAO implements CountableDAO<UserDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class.getName());
  private final ConnectionHelper helper;

  public UserDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(UserDTO dto) {
    // TODO Auto-generated method stub
  }

  @Override
  public UserDTO select(UserDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserDTO> selectAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(UserDTO dto) {
    // TODO Auto-generated method stub

  }
  
  public UserDTO findUser(String name, String email) {
	  
	  UserDTO user = null;
      String sql = "SELECT id FROM user WHERE name = ? AND email = ?";
      
      try (Connection conn = helper.getConnection();
           PreparedStatement psmt = conn.prepareStatement(sql)) {
          psmt.setString(1, name);
          psmt.setString(2, email);
          ResultSet rs = psmt.executeQuery();

          if (rs.next()) {
              user = new UserDTO();
              user.setId(rs.getString("id"));
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return user;
	  
  }

  @Override
  public void delete(UserDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public int count() {
    // TODO Auto-generated method stub
    return 0;
  }
}
