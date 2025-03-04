package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.DataAccessObject;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;
import farmstory.util.Query;

public class UserDAO implements DataAccessObject<UserDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class.getName());
  private final ConnectionHelper helper;

  public UserDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(UserDTO dto) throws DataAccessException {
    try {
      Connection conn = helper.getConnection();
      PreparedStatement psmt = conn.prepareStatement(Query.INSERT_USER);
      psmt.setString(1, dto.getId());
      psmt.setString(2, dto.getPassword());
      psmt.setString(3, dto.getName());
      psmt.setString(4, dto.getNickname());
      psmt.setString(5, dto.getEmail());
      psmt.setString(6, dto.getPhoneNum());
      psmt.setString(7, dto.getZip());
      psmt.setString(8, dto.getAddress());
      psmt.setString(9, dto.getAddressDetail());

      psmt.executeUpdate();
      conn.close();
      psmt.close();
    } catch (NamingException | SQLException e) {
      String msg = String.format("데이터베이스 작업 중 예외가 발생하였습니다: %s", e.getMessage());
      throw new DataAccessException(msg, e);
    }
  }

  @Override
  public UserDTO select(UserDTO dto) {
    return null;
  }

  @Override
  public List<UserDTO> selectAll() {
    return null;
  }
  
  public List<UserDTO> selectResult() {
	  List<UserDTO> dtos = new ArrayList<UserDTO>();
	  String sql = "SELECT `name`, `id`, `email`, `regdate` FROM `user`";
	  
	  try (Connection conn = helper.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            
	            while (rs.next()) {
	                UserDTO user = new UserDTO();
	                user.setName(rs.getString("name"));
	                user.setId(rs.getString("id"));
	                user.setEmail(rs.getString("email"));
	                user.setRegisterDate(rs.getString("registerDate"));
	                dtos.add(user);
	            }
	        } catch (Exception e) {
		LOGGER.error(e.getMessage());
	}
	  
	  return dtos;
  }

  @Override
  public void update(UserDTO dto) {

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

  }

  public int count(String colName, String condition) throws DataAccessException {
    int count = 0;
    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(Query.COUNT_USER)) {
      psmt.setString(1, colName);
      psmt.setString(2, condition);

      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
      rs.close();
    } catch (NamingException | SQLException e) {
      throw new DataAccessException("COUNT 쿼리를 실행하는 도중 예외가 발생하였습니다.", e);
    }
    return count;
  }
}

